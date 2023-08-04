package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("String의 charAt()로 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception이 발생")
    void charAtIndexOut() {
        int idx = 5;
        assertThatThrownBy(() -> { "abc".charAt(idx); })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: "+idx);
    }
}
