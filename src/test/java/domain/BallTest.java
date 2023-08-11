package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    void strikeTest() {
        Ball ball = new Ball(0, "1");
        Balls ansBalls = new Balls("1", "2", "3");

        BallStatus status = ansBalls.getResult(ball);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ballTest() {
        Ball ball = new Ball(0, "1");
        Balls ansBalls = new Balls("2", "1", "3");

        BallStatus status = ansBalls.getResult(ball);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothingTest() {
        Ball ball = new Ball(0, "4");
        Balls ansBalls = new Balls("2", "1", "3");

        BallStatus status = ansBalls.getResult(ball);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
