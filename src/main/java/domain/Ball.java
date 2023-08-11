package domain;

public class Ball {
    private final Integer idx;
    private final Integer number;

    public Ball(int idx, String number) {
        this.idx = idx;
        this.number = Integer.parseInt(number);
    }

    public Integer getIdx() {
        return idx;
    }

    public Integer getNumber() {
        return number;
    }

    public BallStatus getResult(Ball ball) {
        if (this.number == ball.number && this.idx == ball.idx) {
            return BallStatus.STRIKE;
        }
        if (this.number == ball.number) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
