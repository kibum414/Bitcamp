package Homework.Twentyoneth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

// 스레드 사용 위해 Runnable 인터페이스 상속 받음
public class ClientHandler implements Runnable {
    // 송신 및 수신 채널을 받기 위한 변수
    final DataInputStream in;
    final DataOutputStream out;

    // 이름을 받아 오기 위한 변수
    private String name;

    Socket sock;
    boolean isOK;

    Scanner scan = new Scanner(System.in);

    // 생성자 호출 시 매개변수 값들 가져와서 각 변수에 저장
    public ClientHandler(DataInputStream in, DataOutputStream out,
                         String name, Socket sock) {
        this.in = in;
        this.out = out;
        this.name = name;
        this.sock = sock;

        this.isOK = true;
    }

    @Override
    // 스레드가 실행되면
    public void run() {
        String received;

        // 무한 반복하며
        for (;;) {
            try {
                // 입력 값이 있을 시 읽어 오고
                received = in.readUTF();

                // 읽어 온 값을 화면에 출력
                System.out.println(received);

                // 입력 값이 q 이면
                if (received.equals("q")) {
                    // false 값으로 바꾸고
                    this.isOK = false;
                    // 소켓 통신 종료
                    this.sock.close();
                    break;
                }

                // StringTokenizer는 특수한 기준자를 바탕으로 문자열을 분리한다.
                StringTokenizer st = new StringTokenizer(received, "#");
                // 구분자(#) 앞 글자 가져와서 저장
                String recipient = st.nextToken();
                // 구분자(#) 뒷 글자 가져와서 저장
                String msg2Send = st.nextToken();
                // 메시지 내용 출력
                System.out.println("msg2Send = " + msg2Send);
                // 받는 사람 출력
                System.out.println("recipient = " + recipient);

                // 클라이언트 리스트를 차례대로 돌며
                for (ClientHandler ch : ThreadChatServer.chv) {
                    // 서버로부터 받은 이름과 받는 사람으로 입력된 값이 일치하고
                    // q를 입력한 게 아니면 ???
                    if (ch.name.equals(recipient) && ch.isOK == true) {
                        // 송신 채널을 통해 해당 클라이언트에게 보낸 사람과 메시지 내용을 출력
                        ch.out.writeUTF(this.name + " : " + msg2Send);
                        // for 문 탈출
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // q를 입력하고 나온 클라이언트와
            // 송신 및 수신 채널 연결을 끊음
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
