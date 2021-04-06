package com.example.demo.game;

public class DiceGame {
    int comDice;
    int userDice;

    public DiceGame() {
        comDice = (int) (Math.random() * 6) + 1;
        userDice = (int) (Math.random() * 6) + 1;
    }

    public void printWinner() {
        System.out.printf("사용자: %d, 컴퓨터: %d\n",
                comDice, userDice);
        
        if (comDice > userDice) {
            System.out.println("컴퓨터 승 !");
        } else if (comDice < userDice) {
            System.out.println("사용자 승 !");
        } else {
            System.out.println("무승부");
        }
    }
    // 컨트롤러에 새로운 맵핑을 만들어서
    // 사용자가 URL 요청을 하면
    // 주사위 게임이 동작하게 만들어 보자 !
    // 웹 페이지 출력은 Success로
    // 위에서 만들었던 "html_css/success.html" 를 활용한다.
    // 아직 게임 결과를 출력할 수 없으니
    // 콘솔 창에 게임 결과를 출력하도록 한다.
}
