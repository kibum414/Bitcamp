package Exercise._20210303;

// 1. 1 + (1 + 2) + (1 + 2 + 3) + (1 + 2 + 3 + 4) +
//	  ....... + (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)
//	  의 합계를 구하는 프로그램을 작성하시오.

class OneToTenSum {
	private final int ONE = 1;
	private final int TEN = 10;
	
	private int sum;
	
	public OneToTenSum() {
		sum = 0;
	}
	
	public void sumNum() {
		for (int i = ONE; i <= TEN; i++) {
			for (int j = ONE; j <= i; j++) {
				sum += j;
			}
		}
	}
	
	public void printSum() {
		System.out.println("총합 : " + sum);
	}
}

public class Exercise1 {

	public static void main(String[] args) {
		OneToTenSum os = new OneToTenSum();
		
		os.sumNum();
		os.printSum();
	}

}

/*

int sum = 0;
int totalSum = 0;

for(int i=1; i <=10; i++) {
	sum += i;
	totalSum += sum;
}

System.out.println("totalSum="+totalSum);

*/