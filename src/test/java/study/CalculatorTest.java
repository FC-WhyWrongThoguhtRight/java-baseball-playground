package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void destroy() {
        calculator = null;
    }

    @Test
    void initTest() throws IllegalAccessException {
        calculator.init("1 + 2");

        String[] targetField = null;
        for (Field field : calculator.getClass().getDeclaredFields()) {
            if ("values".equals(field.getName())) {
                field.setAccessible(true);
                targetField = (String[]) field.get(calculator);
            }
        }
        assertThat(targetField)
                .containsExactly("1", "+", "2");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 * 3 / 4:2"}, delimiter = ':')
    void calTest(String input, int expected) throws IllegalAccessException {
        for (Field field : calculator.getClass().getDeclaredFields()) {
            if ("values".equals(field.getName())) {
                field.setAccessible(true);
                field.set(calculator, input.split(" "));
            }
        }
        assertThat(calculator.cal())
                .isEqualTo(expected);
    }
}
