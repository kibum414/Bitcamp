package Lecture._20210303.Collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		list.add(1, "APPLE"); // 인덱스 1에 "APPLE"을 삽입
		list.set(2, "GRAPE"); // 인덱스 2의 원소를 "GRAPE"로 대체
		list.remove(3); // 인덱스 3의 원소를 삭제한다.
		
		// .length : 배열 크기
		// .length() : 문자열 길이
		// .size() : 리스트 크기
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println();

		for (String s : list)
			System.out.println(s);
		
		System.out.println();
		
		// indexOf : 해당 값이 있는 인덱스 추출
		int index = list.indexOf("APPLE");
		System.out.println(index);
	}

}
