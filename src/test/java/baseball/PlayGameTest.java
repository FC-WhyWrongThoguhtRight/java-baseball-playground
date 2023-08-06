package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayGameTest {

    PlayGame game;

    @BeforeEach
    void setup(){
        game = new PlayGame(new int[]{1,2,3});
    }

    @Test
    void 스트라이크의_갯수가3개(){
        int actual = game.strikeCount(new UserInput(new int[]{1,2,3}));
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 스크라이크의_개수가_2개(){
        int actual = game.strikeCount(new UserInput(new int[]{1,2,4}));
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 스크라이크의_개수가_1개(){
        int actual = game.strikeCount(new UserInput(new int[]{1,5,4}));
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 스크라이크의_개수가_0개(){
        int actual = game.strikeCount(new UserInput(new int[]{5,6,4}));
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 볼의개수가_3개(){
        int actual = game.ballCount(new UserInput(new int[]{2,3,1}));
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 볼의개수가_2개(){
        int actual = game.ballCount(new UserInput(new int[]{2,6,1}));
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 볼의개수가_1개(){
        int actual = game.ballCount(new UserInput(new int[]{7,6,1}));
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 스트라이크_볼_아무것도_없음(){
        int[] input = new int[]{4,5,6};
        UserInput userInput = new UserInput(input);
        int strikeCount = game.strikeCount(userInput);
        int ballCount = game.ballCount(userInput);
        assertThat(strikeCount + ballCount).isEqualTo(0);
    }

    @Test
    void 결과를_못맞춤(){
        int strikeCount = 2;
        boolean result = game.isWin(strikeCount);
        assertThat(result).isFalse();
    }

    @Test
    void 결과를_맞춤(){
        int strikeCount = 3;
        assertThat(game.isWin(strikeCount)).isTrue();
    }

    @Test
    void 게임지속(){
        assertThat(game.isGameContinue()).isTrue();
    }

    @Test
    void 게임종료(){
        game.setGameFlag(Game.END);
        assertThat(game.isGameContinue()).isFalse();
    }


}
