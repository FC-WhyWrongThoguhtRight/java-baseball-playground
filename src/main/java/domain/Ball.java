package domain;

import java.util.Objects;

// 야구숫자 하나의 위치와 번호
public class Ball {

    private final int position;
    private final int num;

    // 생성자
    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    // 야구숫자 하나를 비교해서 판단하는 메서드
    public BallStatus judge(Ball userBall) {
        if(this.equals(userBall)) {
            return BallStatus.STRIKE;
        }
        if(isSameNo(userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, num);
    }

    // 번호가 같은지 판단하는 메서드
    public boolean isSameNo(Ball userBall) {
        return this.num == userBall.num;
    }
}
