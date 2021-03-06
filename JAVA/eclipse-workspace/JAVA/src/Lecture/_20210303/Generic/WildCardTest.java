package Lecture._20210303.Generic;

import java.util.Arrays;
import java.util.List;

// 상한이 있는 와일드 카드
public class WildCardTest {

	public static void main(String[] args) {
		// 배열을 리스트로 변환
		List<Integer> li = Arrays.asList(1, 2, 3);
		
		System.out.println("sum = " + sumOfList(li));
	}

	// Number만 쓰겠다
	// -> Integer, double, float 등등만 사용하겠다
	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		int sum = 0;
		
		for (Number n : list)
			s += n.doubleValue();
		
		return s;
	}
}
