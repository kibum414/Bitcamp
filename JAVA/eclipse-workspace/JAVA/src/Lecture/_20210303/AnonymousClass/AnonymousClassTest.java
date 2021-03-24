package Lecture._20210303.AnonymousClass;

interface RemoteControl {
	void turnOn();
	void turnOff();
}

// 한 번만 쓰고 지나가는 것들은 이름 없이 사용
// anonymous class
// 클래스 정의와 함께 사용
public class AnonymousClassTest {

	public static void main(String[] args) {
		// 무명 클래스 정의
		RemoteControl ac = new RemoteControl() {
			public void turnOn() {
				System.out.println("TV turnOn()");
			}
			public void turnOff() {
				System.out.println("TV turnOff()");
			}
		};
		
		ac.turnOn();
		ac.turnOff();
	}
}
