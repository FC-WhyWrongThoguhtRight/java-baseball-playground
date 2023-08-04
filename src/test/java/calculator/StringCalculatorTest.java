package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @ParameterizedTest
    @CsvSource(
        value = { "1 + 2:3", "2 + 3 * 4 / 2:10" },
        delimiter = ':'
    )
    public void 유효한_식을_입력하면_결과가_올바르게_나온다(String input, int expected) {
        systemIn(input);

        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.operate()).isEqualTo(expected);
    }

    @Test
    public void 영으로_나누려하면_예외가_발생한다() {
        systemIn("1 / 0");

        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(stringCalculator::operate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "0 0 0", "0 0", "0 0 +" })
    public void 식이_올바르지_않으면_예외가_발생한다(String input) {
        systemIn(input);

        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(stringCalculator::operate).isInstanceOf(IllegalArgumentException.class);
    }
}
