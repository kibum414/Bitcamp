package Exercise._20210303;

// 8. 위 7번 문제를 MyPoint 클래스와 p 객체를 이용하여 작성하시오.

class MyPoint {
	private int x1, x2;
}

public class Exercise8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*

class MyPoint {
	int x; // 인스턴스 변수
	int y;
	
	MyPoint (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance (int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1)
		 			+ (y - y1) * (y - y1));
	}
}

public class Exercise8 {
	
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2, 2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}
}

*/