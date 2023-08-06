package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void strike() {
        Ball computerBall = new Ball(1, 2);
        BallStatus ballStatus = computerBall.judge(new Ball(1, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball computerBall = new Ball(1, 2);
        BallStatus ballStatus = computerBall.judge(new Ball(3, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball computerBall = new Ball(1, 2);
        BallStatus ballStatus = computerBall.judge(new Ball(3, 5));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
