package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("문자열에서 문자 변환")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("문자열을 ','를 기준으로 분리")
    void split() {
        String[] arr;
        arr = "1,2".split(",");
        assertThat(arr).contains("1", "2");

        arr = "1".split(",");
        assertThat(arr).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 괄호 제거")
    void substring() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }
}
