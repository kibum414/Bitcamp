package Lecture._20210303.Generic;

// compareTo : 기본적으로 String에 대해서만 구현되어 있음
class MyArrayAlg {
	// 원래 인터페이스는 implements 사용
	// extends 사용 : 구현되어 있는 부분만 쓰겠다
	// 한정된 타입 매개변수 사용 시에는 extends 사용
	public static <T extends Comparable> T getMax(T[] a) {
		if (a == null || a.length == 0)
			return null;
		
		T largest = a[0];
		
		for (int i = 1; i < a.length; i++)
			if (largest.compareTo(a[i]) < 0)
				largest = a[i];
		
		return largest;
	}
}

public class MyArrayAlgTest {
	public static void main(String[] args) {
		String[] list = { "xyz", "abc", "def" };
		String max = MyArrayAlg.getMax(list);
		
		System.out.println(max);
	}
}