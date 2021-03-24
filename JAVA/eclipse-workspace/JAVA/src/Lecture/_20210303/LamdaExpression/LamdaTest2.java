package Lecture._20210303.LamdaExpression;

@FunctionalInterface
interface MyInterface {
	public void calculate(int x, int y);
}

public class LamdaTest2 {

	public static void main(String[] args) {
		MyInterface hello = (a, b) -> {
			int result = a * b;
			
			System.out.println("계산 결과는 : " + result);
		};
		
		hello.calculate(10, 20);
	}

}
