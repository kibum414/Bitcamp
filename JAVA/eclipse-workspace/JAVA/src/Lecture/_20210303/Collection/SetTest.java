package Lecture._20210303.Collection;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();

		set.add("Milk");
		set.add("Bread");
		set.add("Butter");
		set.add("Cheese");
		set.add("Ham");
		set.add("Ham");
		
		// 중복 X. 순서 자기 마음대로
		System.out.println(set);
	}

}
