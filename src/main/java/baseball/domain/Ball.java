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
            throw new IllegalArgumentException("Ball의 position은 0~2 사이여야 합니다.");
        }
    }

    private void validateNumber(int number) throws IllegalArgumentException {
        boolean outOfNumberRange = number < 1 || number > 9;
        if (outOfNumberRange) {
            throw new IllegalArgumentException("Ball의 number는 1~9 사이여야 합니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
