package Exercise._20210303;

// 2. 숫자로 이루어진 문자열 str이 있을 때,
//	  각 자리의 합을 더한 결과를 출력하는 프로그램을 작성하시오.
//	  예를 들면 문자열이 "12345" 라면,
//	  '1+2+3+4+5'의 결과인 15가 출력되어야 한다.
//	  [Hint] String 클래스의 charAt(int i)을 사용하시오.

public class Exercise2 {

	public static void main(String[] args) {
		SumNum sn = new SumNum("12345");
		
		sn.printSum();
	}

}

/*

String str = "12345";
int sum = 0;

for (int i = 0; i < str.length(); i++) {
	// char 형에서 0을 빼면 숫자가 나옴 (아스키 코드 - 아스키 코드)
	sum += str.charAt(i) - '0';
}

System.out.println("sum = " + sum);

*/