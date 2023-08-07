package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp(){
        com = new Ball(1,4);
    }

    @Test
    @DisplayName("nothing")
    void nothing(){
        assertThat(com.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("ball")
    void ball(){
        assertThat(com.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("strike")
    void strike(){
        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
}
