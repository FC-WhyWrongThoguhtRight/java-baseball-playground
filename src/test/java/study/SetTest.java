package study;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 크기")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }
}
