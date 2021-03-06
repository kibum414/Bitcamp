package Lecture._20210305.Synchronized;

class Counter {
	private int value = 0;
	
	public void increment() {
		// 1. 변수 value의 현재값을 가져온다. (CPU에서)
		// 2. 현재값을 1만큼 증가시킨다. (register에서)
		// 3. 증가된 값을 다시 변수 value에 저장한다.
		value++;
	}
	
	public void decrement() {
		value--;
	}

	// 실행 결과는 컴퓨터와 상황에 따라서 상당히 달라진다.
	// 스레드 간섭이 없다면 모두 0이 출력되어야 한다.
	public void printCounter() {
		System.out.println(value);
	}
}

class MyThread extends Thread {
	
	Counter sharedCounter;
	
	public MyThread(Counter c) {
		// 공유된 Counter 객체의 참조값을 저장한다.
		this.sharedCounter = c;
	}
	
	
	public void run() {
		int i = 0;
		
		while (i < 20000) {
			// 증가했다가 감소시키기 때문에 카운터의 값은 변화가 없어야 한다.
			sharedCounter.increment();
			sharedCounter.decrement();
			
			if (i % 40 == 0)
				// 가끔 카운터의 값을 출력하여 본다.
				sharedCounter.printCounter();
			
			try {
				// 난수 시간만큼 스레드를 중지한다.
				sleep((int) (Math.random() * 2));
			} catch (InterruptedException e) {
				
			}
			
			i++;
		}
	}
}

public class CounterTest {
	
	public static void main(String[] args) {
		// 공유 카운터 객체를 생성한다.
		Counter c = new Counter();
		
		// 확실하게 잘못된 결과를 내기 위해 스레드를 4개나 생성하여 실행한다.
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();
	}

}
