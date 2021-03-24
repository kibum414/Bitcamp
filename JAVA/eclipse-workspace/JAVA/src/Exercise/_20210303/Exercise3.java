package Exercise._20210303;

// 3. int 타입의 변수 num이 있을 때,
//	  각 자리의 합을 더한 결과를 출력하는 프로그램을 작성하시오.
//	  예를 들면 변수 num의 값이 12345라면,
//	  '1+2+3+4+5'의 결과인 15가 출력되어야 한다.

public class Exercise3 {
	public static void main(String[] args) {
		SumNum sn = new SumNum(12345);
		
		sn.printSum();
	}
}

/*

int num = 12345;
int sum = 0;

while (num > 0) {
	sum += num % 10;
	num /= 10;
}

System.out.println("sum = " + sum);

*/