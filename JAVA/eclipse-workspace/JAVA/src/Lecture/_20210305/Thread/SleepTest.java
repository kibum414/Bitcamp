package Lecture._20210305.Thread;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		String messages[] = { "Pride will have a fall.",
				"Power is dangerous unless you have humility.",
				"Office changes manners.",
				"Empty vessels make the most sound." };
		
		for (int i = 0; i < messages.length; i++) {
			// 스레드를 재우는 것
			// 1000 밀리 초 동안 실행을 중지한다.
			Thread.sleep(1000);
			
			System.out.println(messages[i]);
		}
	}

}
