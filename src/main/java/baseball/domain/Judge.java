package baseball.domain;

public class Judge {
    public static JudgeResult judge(Balls answer, Balls input) {
        int strike = answer.countStrike(input);
        int ball = answer.countBall(input);

        return new JudgeResult(strike, ball);
    }
}
