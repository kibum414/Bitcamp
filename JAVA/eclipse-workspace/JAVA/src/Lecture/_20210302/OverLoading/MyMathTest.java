package Lecture._20210302.OverLoading;

public class MyMathTest {

	public static void main(String[] args) {
		int a = 10;
		String s = "Welcome Today";
		
		MyMath obj = new MyMath();
		System.out.println(obj.square(10));
		System.out.println(obj.square(3.14));
		
		// 변수 타입이 다르지만 문제 없이 출력됨
		// println은 메소드 오버로딩이 이미 구현되어 있음
		System.out.println(a);
		System.out.println(s);
	}

}
