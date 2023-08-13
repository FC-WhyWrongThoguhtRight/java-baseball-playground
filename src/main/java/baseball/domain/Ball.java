package baseball.domain;

public class Ball{
    private int position;
    private int number;

    public Ball(int position, int number) throws IllegalArgumentException {
        validatePosition(position);
        this.position = position;

        validateNumber(number);
        this.number = number;
    }

    private void validatePosition(int position) throws IllegalArgumentException {
        boolean outOfPositionRange = position < 0 || position > 2;
        if (outOfPositionRange) {
            // 개발자의 실수로만 발생하는 예외이기에 UnknownError를 던지게 하였음
            throw new UnknownError("Ball의 position은 0~2 사이여야 합니다.");
        }
    }

    private void validateNumber(int number) throws IllegalArgumentException {
        boolean outOfNumberRange = number < 1 || number > 9;
        if (outOfNumberRange) {
            throw new IllegalArgumentException("숫자는 1~9 사이여야 합니다.");
        }
    }

    public boolean matchNumber(Ball targetBall) {
        return this.number == targetBall.number;
    }

    public boolean matchPosition(Ball targetBall) {
        return this.position == targetBall.position;
    }
}
