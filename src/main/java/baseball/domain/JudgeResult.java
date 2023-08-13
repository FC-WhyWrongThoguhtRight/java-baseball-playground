package baseball.domain;

public class JudgeResult {
    private int strike;
    private int ball;

    public JudgeResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (strike + ball == 0) {
            return "낫싱";
        }

        if (strike > 0 && ball == 0) {
            return String.format("%d스트라이크", strike);
        }

        if (strike == 0 && ball > 0) {
            return String.format("%d볼", ball);
        }

        return String.format("%d스트라이크 %d볼", strike, ball);
    }
}
