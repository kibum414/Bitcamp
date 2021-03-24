package Lecture._20210305.Thread;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 소스를 입력하고 Ctrl + Shift + O 를 눌러서 필요한 파일을 포함한다.

// swing 을 사용하여 그래픽 처리
public class CountDownTest extends JFrame {
	private JLabel label;
	
	class MyThread extends Thread {
		public void run() {
			for (int i = 10; i >= 0; i--) {
				try {
					// 1초 단위로 실행
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				label.setText(i + "");
			}
		}
	}
	
	public CountDownTest() {
		// 창 이름
		setTitle("카운트다운");
		// 창 크기
		setSize(300, 200);
		// X 누르면 창 닫히고 끝난다는 것
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Start 나오게 하는 것
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		
		// 세팅한 것을 label에 추가
		add(label);
		new MyThread().start();
		
		// 내가 세팅한 모든 것들을 화면에 보이도록 하는 것
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}

}
