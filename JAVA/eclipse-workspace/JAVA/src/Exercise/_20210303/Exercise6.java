package Exercise._20210303;

// 6. 아래와 같이 배열 answer에 담긴 데이터를 읽고
//	  각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서
//	  아래 그림처럼 출력하는 프로그램을 작성하시오.
//	  int[] answer={1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2}
//
//	  [실행결과]
//	  3***
//	  2**
//	  2**
//	  4**

class Star {
	private final char star = '*';
	
	private int[] answer;
	private int[] count;
	
	public Star() {
		answer = new int[] {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
		count = new int[this.getMax()];
	}
	
	public int getMax() {
		int max = answer[0];
		
		for (int i = 1; i < answer.length; i++) {
			if (max < answer[i]) {
				max = answer[i];
			}
		}
		
		return max;
	}
	
	public void countNum() {
		for (int i = 0; i < answer.length; i++) {
			count[answer[i] - 1]++;
		}
	}
	
	public void printStar() {
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i]);
			
			for (int j = 0; j < count[i]; j++) {
				System.out.print(star);
			}
			
			System.out.println();
		}
	}
}

public class Exercise6 {

	public static void main(String[] args) {
		Star s = new Star();
		
		s.countNum();
		s.printStar();
	}

}

/*

int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
int[] counter = new int[4];

for (int i = 0; i < answer.length; i++) {
	counter[answer[i] - 1]++;
}

for (int i = 0; i < counter.length; i++) {
	System.out.print(counter[i]);
	
	for (int j = 0; j < counter[i]; j++) {
		System.out.print("*"); // counter[i]의 값만큼 '*'을 찍는다.
	}
	
	System.out.println();
}

*/