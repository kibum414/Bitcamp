package Lecture._20210303;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

class MyClass implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		System.out.println("beep");
	}
}

public class CallbackTest {

	public static void main(String[] args) {
		
		ActionListener listener = new MyClass();
		Timer t = new Timer(1000, listener);
		
		// 스레드 동작
		// 스레드 : 프로세스에서 동작하는 각각의 태스크
		t.start();
		
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}

}
