package baseball.domain;

import baseball.ValidationUtils;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        if (!ValidationUtils.validNo(ballNo)) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        //ball null 처리 추가

        //만약 변수가 2가지가 끝이고 2가지가 모두 같다는 코드를 하고 싶으면
        //equals() 를 재정의하여 진행하는 것도 좋은 방식이다.
        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }

        //위에서 포지션값을 비교하니 여기는 포지션 체크를 안해도 된다.
        if(ball.matchBallNo(ballNo)){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    /*
    인스턴스 필드에 직접 접근이 아니라
    객체에 메시지를 보내는 방식을 사용하는 것이 좋다.
     */
    public boolean matchBallNo(int ballNo){
        return this.ballNo == ballNo;
    }

    /*
    equals() 재정의
    선언된 두 변수가 같으면 같다.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
