package Lecture._20210303;

import java.util.Scanner;

// assert: 자바에서 막아 놓음
// 프로젝트 명 오른쪽 버튼 Properties - Run/Debug Settings - .java 클릭
// - edit - Arguments - VM arguments : -ea 입력
// - Apply
public class AssertionTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("날짜를 입력하시오: ");
		int date = input.nextInt();
		
		// 날짜가 1 이상이고 31 이하인지를 검증한다.
		assert(date >= 1 && date <= 31) : "잘못된 날짜: " + date;
		System.out.printf("입력된 날짜는 %d입니다.\n", date);
	}

}
