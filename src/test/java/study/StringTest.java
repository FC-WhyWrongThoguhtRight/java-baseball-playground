package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual;

        actual = "1,2".split(",");
        assertThat(actual).isEqualTo(new String[] { "1", "2" });

        actual = "1".split(",");
        assertThat(actual).isEqualTo(new String[] { "1" } );
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1);
        actual = actual.substring(0, actual.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt(int) 테스트")
    void charAt() {
        String foo = "abc";

        assertThat(foo.charAt(0)).isEqualTo('a');
        assertThat(foo.charAt(1)).isEqualTo('b');
        assertThat(foo.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            foo.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");

        assertThatThrownBy(() -> {
            foo.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: -1");
    }
}
