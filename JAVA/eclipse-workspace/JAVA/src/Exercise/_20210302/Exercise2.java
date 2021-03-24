package Exercise;

// 2. 임의의 숫자로 로또 번호 6개를 출력하는 프로그램을 작성하시오.

class lotto {
    private final int NUM = 45;
    private final int COUNT = 6;
    private final int ZERO = 0;

    private int[] lottoArr;
    private int[] checkArr;
    private int lottoNum, cnt;

    public lotto() {
        System.out.println("로또를 시작합니다.");

        lottoArr = new int[COUNT];
        checkArr = new int[NUM];
        cnt = 0;

        for (int i = 0; i < NUM; i++) {
            checkArr[i] = 0;
        }
    }

    public void playGame() {
        for (;;) {
            lottoNum = (int) (Math.random() * NUM + 1);

            if (checkArr[lottoNum] == 0) {
                lottoArr[cnt] = lottoNum;
                cnt++;
            }

            if (cnt == 6) {
                break;
            }
        }
    }

    public void printResult() {
        System.out.println("이번주 로또 결과 ");

        for (int i = ZERO; i < COUNT; i++) {
            System.out.printf("%3d", lottoArr[i]);
        }
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        lotto l = new lotto();

        l.playGame();
        l.printResult();
    }
}
