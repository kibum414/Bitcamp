package Lecture._20210303.Lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// Treeset 이용한 Lotto Number 생성
public class Lotto2 {

	public static void main(String[] args) {
		// HashSet : 속도는 빠르나 정렬되지 않음
		// TreeSet : 속도는 비교적 느리나 정렬되어 나옴
		Set<Integer> set = new TreeSet<Integer>();
		// Set set = new HashSet();
		
		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
		
			set.add(num);
		}
		
		System.out.println(set);
	}

}
