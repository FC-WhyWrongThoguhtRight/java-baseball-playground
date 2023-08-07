package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("1~9 사이 숫자 확인 하기")
    void 숫자예외처리1(){
        // 테스트 값은 경계값으로 진행하자.
       assertThat(ValidationUtils.validNo(1)).isTrue();
       assertThat(ValidationUtils.validNo(9)).isTrue();
       assertThat(ValidationUtils.validNo(0)).isFalse();
       assertThat(ValidationUtils.validNo(10)).isFalse();
    }

    @Test
    @DisplayName("중복수 확인하기")
    void 숫자예외처리2(){
        // 테스트 값은 경계값으로 진행하자.
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }
}
