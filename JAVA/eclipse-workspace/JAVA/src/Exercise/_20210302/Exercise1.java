package Exercise;

// 1. 0부터 짝수를 더해서 합계가 100을 넘지 않는 마지막 짝수와
//    그 값까지 더한 합계를 한줄씩 출력하세요.
class evenSum {
    private final int ZERO = 0;
    private final int HUNDRED = 100;
    private int sum, lastNum;

    public evenSum() {
        sum = 0;
    }

    public void sum() {
        for (int i = ZERO; ; i++) {
            if (i % 2 == 0) {
                sum += i;
            }

            if (sum > HUNDRED) {
                sum -= i;
                lastNum = i;

                break;
            }
        }
    }

    public void printSum() {
        System.out.println("합계가 " + HUNDRED + "을 넘지 않는 마지막 짝수 : " + lastNum);
        System.out.println("총합 : " + sum);
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        evenSum es = new evenSum();

        es.sum();
        es.printSum();
    }
}
