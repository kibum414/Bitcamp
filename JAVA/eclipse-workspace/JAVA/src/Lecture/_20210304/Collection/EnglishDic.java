package Lecture._20210304.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnglishDic {

	public static void main(String[] args) {
		Map<String, String> st = new HashMap<String, String>();
		
		// put은 key값과 value값 같이 써야됨
		st.put("map", "지도");
		st.put("java", "자바");
		st.put("school", "학교");
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("영어 단어를 입력하세요 : ");
			
			String key = sc.next();
			
			if (key.equals("quit"))
				break;
			
			// get은 key값만 넣어주면 key에 해당하는 value값을 가져옴
			System.out.println("단어의 의미는 " + st.get(key));
		} while (true);
	}

}
