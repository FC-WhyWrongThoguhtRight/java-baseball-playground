package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void contains() {
        String[] split1 = "1,2".split(",");
        assertThat(split1).containsExactly("1", "2");

        String[] split2 = "1".split(",");
        assertThat(split2).containsExactly("1");
    }

    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt()메소드로 문자를 가져오는 테스트")
    void charAt() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(5));
    }
}
