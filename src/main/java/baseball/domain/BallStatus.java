package baseball.domain;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
