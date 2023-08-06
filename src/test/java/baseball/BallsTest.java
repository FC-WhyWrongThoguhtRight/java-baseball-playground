package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    Balls balls;

    @BeforeEach
    void Balls초기화(){
        balls = new Balls();
    }

    @Test
    void Balls의길이가3인가(){
        assertThat(balls.getLength()).isEqualTo(3);
    }

    @Test
    void Balls의_각_수가_다른숫자인가(){
        boolean actual = balls.validateBalls();
        assertThat(actual).isTrue();
    }



}
