package baseball.service;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.domain.RandomBalls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayService {

    public List<Integer> creteRandom(){
        RandomBalls randomBalls = new RandomBalls();

        return randomBalls.createRandomNum();
    }

    public boolean startGame(List<Integer> answers){
        System.out.println("숫자를 입력하세요 :  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<Integer> user_balls = new ArrayList<>();

        for (String number : input.split("")) {
            user_balls.add(Integer.parseInt(number));
        }

        return resultJudge(answers, user_balls);
    }

    public void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        if (result == 2) {
            System.exit(0);
        }
    }

    public boolean resultJudge(List<Integer> answers, List<Integer> user_balls){
        Balls balls = new Balls(answers);
        StringBuilder sb = new StringBuilder();

        PlayResult playResult = balls.play(user_balls);

        if(playResult.getEndGame()){
            return true;
        }

        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if (strike == 0 && ball == 0) {
            sb.append("포볼");
        }

        if(strike > 0){
            sb.append(strike + "스트라이크 ");
        }

        if(ball > 0){
            sb.append(ball + "볼 ");
        }

        System.out.println(sb.toString());

        return false;
    }
}
