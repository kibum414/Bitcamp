package Lecture._20210303.Collection;

import java.util.Vector;

// 배열은 사이즈 지정 이후 변경 불가능
// Vector는 사이즈 제한 없이 변경 가능

/*
Collection : 모든 자료 구조의 부모 인터페이스로서 객체의 모임을 나타낸다.
Set : 집합(중복된 원소를 가지지 않는)을 나타내는 자료 구조
 - HashSet : 해시 테이불에 원소 저장. 성능 가장 우수, 순서 뒤죽박죽
 - TreeSet : 레드-블랙 트리에 원소 저장. HashSet에 비해 느림
 - LinkedHashSet : 해쉬 테이블과 연결 리스트 결합. 입력한 순서대로 나옴 
List : 순서가 있는 자료 구조로 중복된 원소를 가질 수 있다.
 - ArrayList : Vector 개선, 데이터를 가져오는 속도가 빠름, 값 추가, 삭제 사용 안 할 경우 이용
 			   .add(추가), .set(대체), .remove(삭제)
 - LinkedList(참조 변수) : 속도가 비교적 느림, 반복적인 값 추가, 삭제 시 효율적
Map : 키와 값들이 연관되어 있는 사전과 같은 자료 구조
Queue : 극장에서의 대기줄과 같이 들어온 순서대로 나가는 자료구조
*/

public class VectorTest {

	public static void main(String[] args) {
		Vector vc = new Vector();
		
		// 값 추가하기
		vc.add("Hello World!");
		vc.add(new Integer(10));
		vc.add(20);
		
		System.out.println("vector size : " + vc.size());
		
		for (int i = 0; i < vc.size(); i++) {
			System.out.println("vector element " + i + " : " + vc.get(i));
		}
		
		// 값 얻어오기
		String s = (String)vc.get(0);
		System.out.println(s);
	}

}
