package baseball;

import baseball.model.ComputerBalls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    ComputerBalls balls;

    @BeforeEach
    void setUp(){
        balls = new ComputerBalls();
    }

    @Test
    void Balls는_3개의_ball을_가졌나(){
        int count = balls.ballsSize();
        assertThat(count).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0","1:1","2:2"}, delimiter = ':')
    void Balls는_각각인덱스가_있는가(int index, int result){
        int i = balls.getBall(index).getIndex();
        assertThat(i).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void Balls의_ball가_0제외_숫자를_가지고있는가(int index){
        int number = balls.getNumber(index).getNumber();
        assertThat(number).isNotEqualTo(0);
    }

    @Test
    void Balls의_숫자들은_전부_다른가(){
        int num0 = balls.getNumber(0).getNumber();
        int num1 = balls.getNumber(1).getNumber();
        int num2 = balls.getNumber(2).getNumber();
        assertThat(num0).isNotEqualTo(num1).isNotEqualTo(num2);
    }



}
