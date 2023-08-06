package utils;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    void 야구_숫자_1_9_검증() {
        assertThat(ValidationUtils.validNo(1)).isTrue();
    }

    @Test
    void 야구_숫자_크기_검증() {
        Set<Integer> numbers = new HashSet<>(new ArrayList<>(Arrays.asList(1,2)));
        assertThat(ValidationUtils.validSize(numbers)).isTrue();
        numbers.add(3);
        assertThat(ValidationUtils.validSize(numbers)).isFalse();
    }
}
