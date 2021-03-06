package Exercise._20210304;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// 3. 다음에 제시된 Student 클래스의 생성자를 추가한 후, Comparable 인터페이스를 구현하도록 변경해서
//	  이름(name)이 기본 정렬 기준이 되도록 하시오.

/*
import java.util.*;

class Student {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 * 0.5) / 10f;
	}
	
	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
	}
}

class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Collections.sort(list);
		
		Iterator it = list.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}
}

[실행 결과]
김자바, 1, 3, 80, 80, 90, 250, 83.3
남궁성, 1, 2, 90, 70, 80, 240, 80.0
안자바, 1, 5, 60, 100, 80, 240, 80.0
이자바, 1, 4, 70, 90, 70, 230, 76.7
홍길동, 1, 1, 100, 100, 100, 300, 100.0
 */

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
	}

	// compareTo 사용 시에는
	// 반드시 if 문을 사용하여
	// 객체가 같은 타입인지 확인하는 것이 안전
	public int compareTo(Object o) {
		// Student의 객체이면
		if(o instanceof Student) {
			Student tmp = (Student) o;
			
			return name.compareTo(tmp.name); // String 클래스의 compareTo()를 호출
		} else {
			return -1;
		}
	}
}

public class Exercise3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Collections.sort(list); // list에 저장된 요소들을 정렬한다. (compareTo() 호출)
		
		Iterator it = list.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}

}
