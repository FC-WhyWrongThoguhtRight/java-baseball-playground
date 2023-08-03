package domain.calculator;

import domain.BaseBallStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorImplTest {
    private CalculatorImpl calculator;

    @BeforeEach
    void init() {
        calculator = new CalculatorImpl();
        calculator.init();
    }

    @AfterEach
    void destroy() {
        calculator = null;
    }

    @Test
    void initTest() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        calculator.init();

        Field numberField = calculator.getClass().getDeclaredField("number");
        Field lengthField = calculator.getClass().getDeclaredField("LENGTH");
        numberField.setAccessible(true);
        lengthField.setAccessible(true);
        String number = (String) numberField.get(calculator);
        int length = lengthField.getInt(calculator);

        Method isValidNumberMethod = calculator.getClass().getDeclaredMethod("isValidNumber", int.class);
        isValidNumberMethod.setAccessible(true);

        assertThat(Integer.parseInt(number)).isLessThan((int) Math.pow(10, length));
        assertThat(isValidNumberMethod.invoke(calculator, Integer.parseInt(number))).isEqualTo(true);
    }

    @Test
    void calculateTest() {
        assertThat(calculator.calculate("123"))
                .isInstanceOf(BaseBallStatus.class);
    }
}