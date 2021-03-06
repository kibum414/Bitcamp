package Lecture._20210303.Shape;

// 아무것도 없는 것 : 같은 패키지는 쓸 수 있으나 자손 클래스는 쓸 수 없음
// protected : 같은 패키지, 자손 클래스 모두에서 쓸 수 있음

class Shape {
	protected int x, y;
	
	public void draw() {
		System.out.println("Shape Draw");
	}
	
	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}
}

class Rectangle extends Shape {
	private int width, height;
	
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle extends Shape {
	private int base, height;
	
	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Circle extends Shape {
	private int radius;
	
	public void draw() {
		System.out.println("Circle Draw");
	}
}

public class ShapeTest {

	public static void main(String[] args) {
		Shape s1, s2;
		
		s1 = new Shape();
		// 상향 형변환
		s2 = new Rectangle();
		

		Shape s = new Rectangle();
		Rectangle r = new Rectangle();
		
		s.x = 0;
		s.y = 0;
		
		System.out.println(s);
		
		// 자식 클래스에서 선언된 변수는 부모 클래스에서 접근 불가
		// 부모 클래서 만들어놓은 변수에만 접근 가능
		// s.width = 100;
		// s.height = 100;
		
		Shape s01, s02, s03, s04;
		
		s01 = new Shape();
		s02 = new Rectangle();
		s03 = new Triangle();
		s04 = new Circle();

		s01.draw();
		s02.draw();
		s03.draw();
		s04.draw();
	}

}
