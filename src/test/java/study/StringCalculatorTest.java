package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("주어진 식에 대한 결과값 반환")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10","3 + 4:7","5 * 3:15","9 / 4:2","5 - 2:3","5 + 4 * 3 - 2 / 2:12"}, delimiter = ':')
    public void testCalculate(String str, int expect) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(StringCalculator.calculate(str)).isEqualTo(expect);
    }
}