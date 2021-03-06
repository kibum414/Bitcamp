package Lecture._20210303.DefaultMethod;

interface MyInterface {
	public void myMethod1();
	
	// 인터페이스는 원래 추상 메소드만 존재할 수 있으나
	// java 8 버전 부터는
	// default method를 사용하여
	// 인터페이스 내에서도 메소드 내용을 적을 수 있음
	default void myMethod2() {
		System.out.println("myMethod2()");
	}
}
public class DefaultMethodTest implements MyInterface {
	public void myMethod1() {
		System.out.println("myMethod1()");
	}
	
	public static void main(String[] args) {
		DefaultMethodTest obj = new DefaultMethodTest();
		
		// 일반적인 메소드 호출과 같음
		obj.myMethod1();
		obj.myMethod2();
	}

}
