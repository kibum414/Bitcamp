package Exercise._20210303;

import java.util.Scanner;

// 7. 두 점의 거리를 계산하는 프로그램을
//	  static 메서드인 getDistance()를 사용하여 작성하시오.
//	  [Hint] 제곱근 계산은 Math.sqrt(double)를 사용하세요.

// 정적 메소드 : 공유 개념. 객체를 생성하지 않고 직접 쓸 수 있는 메소드
// ex. Math.random() : Math 클래스의 random 메소드
class Distance {
	private int x1, x2;
	private int y1, y2;
	
	Scanner scan;
	
	public Distance() {
		scan = new Scanner(System.in);
		
		System.out.println("두 점의 좌표를 각각 입력하세요.");
		x1 = scan.nextInt();
		y1 = scan.nextInt();
		x2 = scan.nextInt();
		y2 = scan.nextInt();
	}
	
	public static double getDistance(int x1, int x2, int y1, int y2) {
		double d1 = Math.pow(x1 - x2, 2);
		double d2 = Math.pow(y1 - y2, 2);
		
		double distance = Math.sqrt(d1 + d2);
		
		return distance;
	}
	
	public void printDistance() {
		System.out.println(getDistance(x1, x2, y1, y2));
	}
}

public class Exercise7 {

	public static void main(String[] args) {
		Distance d = new Distance();
		
		d.printDistance();
	}

}

/*

static double getDistance(int x, int y, int x1, int y1) {
	// s, y는 지역변수
	return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
}

public static void main(String args[]) {
	System.out.println(getDistance(1, 1, 2, 2);
}

*/