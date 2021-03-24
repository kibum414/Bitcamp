package Lecture._20210305.Thread;

// Runnable 인터페이스 상속 - 자바에서는 이 방법을 권함
class MyRunnable implements Runnable {
	public void run() {
		for (int i = 10; i >= 0; i--)
			System.out.print(i + " ");
	}
}

public class MyRunnableTest {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		
		t.start();
	}

}
