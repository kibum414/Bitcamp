package Lecture._20210305.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		Runnable r1 = () -> {
			for (int i = 10; i >= 0; i--)
				System.out.println("첫 번째 스레드: " + i);
		};
		
		Runnable r2 = () -> {
			for (int i = 10; i >= 0; i--)
				System.out.println("두 번째 스레드: " + i);
		};
		
		// Executor
		// 스레드 풀을 제공해줌
		// 스레드를 알아서 생성해주고 처리해줌
		// 풀이라는 것은 미리 준비해두는 것이기 때문에 처리 속도가 빠름
		Executor executor = Executors.newCachedThreadPool();
		
		executor.execute(r1);
		executor.execute(r2);
	}

}
