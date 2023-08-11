package baseball.domain;

import java.util.Objects;

public class BallNumber {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private int ballNo;

    public BallNumber(int ballNo) {
        if (!(ballNo >= MIN_NUM && ballNo <= MAX_NUM)) {
            throw new IllegalArgumentException("볼의 숫자는 1~9사이 값이어야 합니다.");
        }
        this.ballNo = ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNo == that.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNo);
    }
}
