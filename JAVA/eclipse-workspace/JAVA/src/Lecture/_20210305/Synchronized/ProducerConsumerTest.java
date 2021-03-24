package Lecture._20210305.Synchronized;

// ProducerConsumer Issue
// 중복되거나 순서가 바뀔 염려가 없음

// 케잌을 보관하는 선반을 의미하는 클래스
class Buffer {
	private int data;
	private boolean empty = true;
	
	// 케잌을 가져가는 메서드
	public synchronized int get() {
		// 비어 있으면 기다림
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		empty = true;
		
		// 잠자고 있는(sleep) 스레드를 깨어나게 함
		// 가져갔다고 알림
		// 잠자고 있는 put 메서드 스레드를 깨움
		notifyAll();
		
		return data;
	}
	
	// 케잌을 만들어서 놓는 메서드
	public synchronized void put(int data) {
		// 케잌이 있으면 기다림
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		empty = false;
		
		this.data = data;
		
		// 케잌을 두고 notifyAll 하면
		// 잠자고 있는 get 메서드 내 wait()을 깨움
		notifyAll();
	}
	
	// 위 두 스레드가 번갈아가며 일어나 케잌이 중복되거나 순서가 바뀔 일이 없음
}

class Producer implements Runnable {
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("생산자: " + i + "번 케잌을 생산하였습니다.");
			
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer implements Runnable {
	private Buffer buffer;
	
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			int data = buffer.get();
			System.out.println("소비자: " + data + "번 케잌을 소비하였습니다.");
			
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		new Thread(new Producer(buffer)).start();
		new Thread(new Consumer(buffer)).start();
	}

}
