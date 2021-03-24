package Exercise;

// 3. 유원지에서 말을 태워주는데 처음 30분의 기본요금은 3000원이다.
//    이후에는 10분당 500원의 추가 요금을 받는다.
//    말을 탄 시간(분)을 입력 받아서 전체 요금을 계산하는 프로그램을 작성하세요.
//    (단, 1분이라도 시간 초과 시 10분 요금을 추가합니다.)

import java.util.Scanner;

class Fare {
    private final int FIRSTTIME = 30;
    private final int BASICFARE = 3000;
    private final int ADDTIME = 10;
    private final int EXTRACHARGE = 500;

    private int time, overTime, fare;

    Scanner scan;

    public Fare() {
        scan = new Scanner(System.in);

        System.out.print("말을 탄 시간(분)을 입력하세요. ");
        time = scan.nextInt();
    }

    public void calcFare() {
        if (time <= FIRSTTIME) {
            fare = BASICFARE;
        } else {
            overTime = (time - FIRSTTIME) / ADDTIME + 1;

            fare = BASICFARE + overTime * EXTRACHARGE;
        }
    }

    public void printFare() {
        System.out.println(time + "분 동안 이용한 요금은 " + fare + "원 입니다.");
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Fare f = new Fare();

        f.calcFare();
        f.printFare();
    }
}
