package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class BallTest {

    Ball ball;

    @BeforeEach
    void Ball객체생성(){
        ball = new Ball();
    }

    @Test
    void 임의의숫자를만드는가(){
        int result = ball.makeNumber();
        assertThat(result).isNotEqualTo(0); //인트 초기값이 아닌지 확인.
    }

    @Test
    void 숫자가0과9사이인가(){
        boolean actual = ball.validateNumber(ball.getNumber());
        assertThat(actual).isTrue();
    }



}
