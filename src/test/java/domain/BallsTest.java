package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void playBall_strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 1);
        BallStatus ballStatus = computerBalls.playBall(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void playBall_ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 2);
        BallStatus ballStatus = computerBalls.playBall(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void playBall_nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 4);

        BallStatus ballStatus = computerBalls.playBall(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
