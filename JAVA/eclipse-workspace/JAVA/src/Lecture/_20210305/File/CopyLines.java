package Lecture._20210305.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

	public static void main(String[] args) throws IOException{
		// 버퍼를 너무 크게 잡으면 버퍼가 다 찰 때까지 안 보냄 -> 송수신이 늦어짐
		// 버퍼를 너무 작게 잡으면 넘쳐서 오버헤드가 생김
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		
		// 두 개의 처리 속도가 다른 경우에 버퍼를 사용하여 완화시킬 수 있음
		// 처리 속도가 다르면 컴퓨터가 기다려야 하기 때문에 오래 걸림
		// 버퍼를 사용하여 저장하여 놓고 처리를 할 수 있게 해줌
		try {
			// FileReader에 BufferedReader를 연결한다.
			inputStream = new BufferedReader(new FileReader("input.txt"));
			// FileWriter의 출력이 Printwriter의 입력이 된다.
			outputStream = new PrintWriter(new FileWriter("output.txt"));
			
			String l;
			
			// 한 줄 단위로 입출력할 수 있다.
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
