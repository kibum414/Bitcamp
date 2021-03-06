package Lecture._20210303.Collection;

import java.util.HashSet;
import java.util.Set;

public class FindDupplication {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		
		String[] sample = { "단어", "중복", "구절", "중복" };
		
		for (String a : sample)
			// 중복되면 추가되지 않음 -> false
			if (!s.add(a))
				System.out.println("중복된 단어: " + a);
		
		System.out.println(s.size() + " 중복되지 않은 단어: " + s);
	}

}
