package Exercise._20210304;

import java.util.Scanner;

// 2. 다음은 1~100 사이의 숫자를 맞추는 게임을 실행하던 도중에 숫자가 아닌 영문자를 넣어서 발생한 예외이다.
//	  예외처리를 해서 숫자가 아닌 값을 입력했을 때는 다시 입력을 받도록 보완하라.

/*
1과 100 사이의 값을 입력하세요 :50
더 작은 수를 입력하세요.
import java.util.*;

class Exercise8_8
{
	public static void main(String[] args)
	{
		// 1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0; // 사용자 입력을 저장할 공간
		int count = 0; // 시도 횟수를 세기 위한 변수
		
		do {
			count++;
			
			System.out.print("1과 100 사이의 값을 입력하세요 :");
			input = new Scanner(System.in).nextInt();
			
			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도 횟수는 " + count + "번 입니다.");
				
				break; // do-while 문을 벗어난다.
			}
		} while (true); // 무한 반복문
	} // end of main
} // end of class HighLow

[실행 결과]
1과 100 사이의 값을 입력하세요 :50
더 작은 수를 입력하세요.
1과 100 사이의 값을 입력하세요 :asdf
유효하지 않은 값입니다. 다시 값을 입력해 주세요.
1과 100 사이의 값을 입력하세요 : 25
더 큰 수를 입력하세요.
 */
public class Exercise2 {

	public static void main(String[] args) {
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		int count = 0;
		
		do {
			count++;
			
			System.out.print("1~100 사이의 값을 입력하세요 :");

			try {
				input = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.out.println("유효하지 않은 값입니다. 다시 값을 입력해 주세요.");
				
				continue;
			}
			
			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도 횟수는 " + count + "번 입니다.");
				
				break;
			}
		} while (true);
	}

}
