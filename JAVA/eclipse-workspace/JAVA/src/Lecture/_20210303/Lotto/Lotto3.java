package Lecture._20210303.Lotto;

import java.util.Arrays;

public class Lotto3 {

	public static void main(String[] args) {
		// 45개의 정수값을 저장하기 위한 배열 생성
		int[] number = new int[45];
		int[] selectedNumber = new int[6];
		
		// 배열의 각 요소에 1 ~ 45의 값을 저장한다.
		for (int i = 0; i < number.length; i++) {
			// number[0]에 1이 저장된다.
			number[i] = i + 1;
		}
		
		// 두 값을 바꾸는데 사용할 임시 변수
		int temp = 0;
		// 임의의 값을 얻어서 저장할 변수
		int j = 0;
		
		// 배열의 i 번째 요소와 임의의 요소에 저장된 값을
		// 서로 바꿔서 값을 섞는다.
		// 0 번째부터 5 번째 요소까지 모두 6개만 바꾼다.
		for (int i = 0; i < 6; i++) {
			// 0 ~ 44 범위의 임의의 값을 얻는다.
			j = (int) (Math.random() * 45);
			
			temp = number[i];
			number[i] = number[j];
			number[j] = temp;
		}
		
		// System.arraycopy : 배열 복사
		// number라는 배열 (45)에서 selectedNumber(6개)로 복사
		// 0: 처음부터, length(6)만큼 복사
		System.arraycopy(number, 0, selectedNumber, 0, selectedNumber.length);
		Arrays.sort(selectedNumber);
		
		// 배열 number이 앞에서부터 6개의 요소를 출력한다.
		for (int i = 0; i < 6; i++) {
			System.out.printf(
					"selectedNumber[%d] = %d\n",
					i, selectedNumber[i]);
		}
	}

}
