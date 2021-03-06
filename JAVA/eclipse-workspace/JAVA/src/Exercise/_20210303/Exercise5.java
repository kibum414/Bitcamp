package Exercise._20210303;

import java.util.Scanner;

// 5. 변수 money의 금액을 동전으로 바꾸었을 때
//	  각각 몇 개의 동전이 필요한지 계산해서 출력하라.
//	  단, 가능한 한 적은 수의 동전으로 거슬러 주어야 한다.
//	  [Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.

class Money {
	private final int[] coin = {500, 100, 50, 10};
	
	private int money;
	private int[] coinNum;
	
	Scanner scan;
	
	public Money() {
		scan = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요. ");
		money = scan.nextInt();
		
		coinNum = new int[coin.length];
	}
	
	public void calcCoinNum() {
		for (int i = 0; i < coin.length; i++) {
			coinNum[i] = money / coin[i];
			
			money %= coin[i];
		}
	}
	
	public void printCoinNum() {
		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + "원 : "
					+ coinNum[i] + "개");
		}
	}
}

public class Exercise5 {

	public static void main(String[] args) {
		Money m = new Money();
		
		m.calcCoinNum();
		m.printCoinNum();
	}

}

/*

// 큰 금액의 동전을 우선적으로 거슬러줘야 한다.
int[] coinUnit = {500, 100, 50, 10};
int money = 2680;

System.out.println("money = " + money);

for (int i = 0; i < coinUnit.length; i++) {
	System.out.println(coinUnit[i] + "원: " + money / coinUnit[i]);
	
	money = money % coinUnit[i];
}

*/