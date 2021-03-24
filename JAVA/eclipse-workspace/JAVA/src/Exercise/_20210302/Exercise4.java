package Exercise;

// 배달 도시락을 주문하는데 10개까지는 개당 5000원이고
// 10개를 초과하는 양에 대해서는 개당 4800원이다.
// 배달 도시락의 주문 개수를 입력 받아서
// 전체 금액을 계산하는 프로그램을 작성하시오.

import java.util.Scanner;

class lunchBox {
    private final int TEN = 10;
    private final int BASICPRICE = 5000;
    private final int OVERTENPRICE = 4800;

    private int lunch, totalPrice;

    Scanner scan;

    public lunchBox() {
        scan = new Scanner(System.in);
        totalPrice = 0;

        System.out.print("배달 도시락 개수를 입력하세요. ");
        lunch = scan.nextInt();
    }

    public void calcPrice() {
        if (lunch <= TEN) {
            totalPrice = lunch * BASICPRICE;
        } else {
            totalPrice = lunch * OVERTENPRICE;
        }
    }

    public void printPrice() {
        System.out.printf("배달 도시락 %d개의 총 금액은 %d원 입니다.\n", lunch, totalPrice);
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        lunchBox lb = new lunchBox();

        lb.calcPrice();
        lb.printPrice();
    }
}
