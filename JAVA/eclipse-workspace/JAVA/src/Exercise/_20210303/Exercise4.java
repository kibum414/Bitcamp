package Exercise._20210303;

import java.util.Scanner;

// 사용자로부터 값을 받아서 5명의 성적을 배열에 채운 후에
// 배열을 매개변수로 받는 메소드를 작성하여
// 배열에 저장된 모든 값의 평균을 구하는 프로그램을 작성하시오.

class ScoreAvg {
	private final int PERSONNUM = 5;
	
	private int[] score;
	private int sum;
	private double avg;
	
	Scanner scan;
	
	public ScoreAvg() {
		scan = new Scanner(System.in);
		score = new int[PERSONNUM];
		sum = 0;
		avg = 0;
		
		System.out.println(PERSONNUM + "명의 성적을 "
				+ "차례대로 입력하세요. ");
		for (int i = 0; i < PERSONNUM; i++) {
			score[i] = scan.nextInt();
		}
	}
	
	public void calcAvg() {
		for (int i = 0; i < PERSONNUM; i++) {
			sum += score[i];
		}
		
		avg = sum / (double) PERSONNUM;
	}
	
	public void printAvg() {
		System.out.printf("평균 : %.2f\n", avg);
	}
}

public class Exercise4 {

	public static void main(String[] args) {
		ScoreAvg sa = new ScoreAvg();
		
		sa.calcAvg();
		sa.printAvg();
	}

}

/*



*/