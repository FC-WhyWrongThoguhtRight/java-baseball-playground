package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);
    }

    private List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();

        for(Ball answer : answers){
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }

        return result;
    }

    /*
    테스트를 진행하니
    잘 모르는 함수 사용에 거부감이 없다.
    문법공부에 용이하다.
    자바 stream 활용
    더블 콜론
     */
    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
