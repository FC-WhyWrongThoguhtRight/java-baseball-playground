package baseball.domain.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RandomBallsGeneratorTest {
    @RepeatedTest(value = 100)
    void 중복되지_않는_1_9_사이의_Balls를_만든다() {
        // 중복되거나 1~9 사이의 숫자가 아니라면 Ball, Balls 객체 생성 단계에서 예외가 발생함
        assertDoesNotThrow(() -> RandomBallsGenerator.generate());
    }
}