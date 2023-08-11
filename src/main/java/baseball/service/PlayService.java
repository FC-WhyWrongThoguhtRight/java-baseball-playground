package baseball.service;

import baseball.ValidationUtils;
import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.domain.RandomBalls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayService {

    public List<Integer> creteRandom() {
        RandomBalls randomBalls = new RandomBalls();
        return randomBalls.createRandomNum();
    }

    public boolean startGame(List<Integer> answers) {
        System.out.println("숫자를 입력하세요 :  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Integer> user_balls = new ArrayList<>();

        for (String number : input.split("")) {
            user_balls.add(Integer.parseInt(number));
        }

        if (!ValidationUtils.duplicatedNo(user_balls)) {
            throw new IllegalArgumentException("중복된 숫자값을 허용하지않습니다.");
        }

        if (!ValidationUtils.lengthNo(user_balls)) {
            throw new IllegalArgumentException("정해진 숫자 길이 : " + ValidationUtils.SIZE_NUM + "을 맞추어 주세요.");
        }

        return getResult(answers, user_balls);
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        if (result == 2) {
            scanner.close();
            System.exit(0);
        }
    }

    public boolean getResult(List<Integer> answers, List<Integer> user_balls) {
        Balls balls = new Balls(answers);
        StringBuilder sb = new StringBuilder();

        PlayResult playResult = balls.play(user_balls);

        if (playResult.getEndGame()) {
            return true;
        }

        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if (strike == 0 && ball == 0) {
            sb.append("포볼");
        }

        if (strike > 0) {
            sb.append(strike + "스트라이크 ");
        }

        if (ball > 0) {
            sb.append(ball + "볼 ");
        }

        System.out.println(sb.toString());

        return false;
    }
}
