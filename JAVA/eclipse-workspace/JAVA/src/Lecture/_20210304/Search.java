package Lecture._20210304;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search {

	// binary Search는 리스트 정렬이 되어 있는 상태로 진행되어야 함
	// 인덱스를 찾는 것
	public static void main(String[] args) {
		int key = 50;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++)
			list.add(i);
		
		int index = Collections.binarySearch(list, key);
		
		if (index < 0)
			list.add(-index - 1);
		
		System.out.println("탐색의 반환값 = " + index);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
	}

}

// 탐색의 반환값 = 50
// for (int i = 0; i < 100; i += 2) 일 경우엔, 반환값 = 25