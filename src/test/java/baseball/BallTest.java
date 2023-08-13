package baseball;

import baseball.model.Ball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    Ball p;

    @BeforeEach
    void setup(){
        p = new Ball(1);
    }

    @Test
    void Pitch가_인덱스를_가지고있나(){
        int index = p.getIndex();
        assertThat(index).isNotEqualTo(0);
    }

    @Test
    void Pitch가_number를_가지고있나(){
        int number = p.getNumber();
        assertThat(number).isNotEqualTo(0);
    }

    @Test
    void 랜덤으로_0제외_숫자를_생성하는가(){
        int result = p.makeRandomNumber();
        assertThat(result).isNotEqualTo(0);
    }


}
