package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    BaseballGame game;

    @BeforeEach
    void setUp() {
        game = new BaseballGame(new Balls("123"));
    }

    @Test
    void 낫싱() {
        assertEquals(game.guess("456"), "낫싱");
    }

    @Test
    void 볼_1() {
        assertEquals(game.guess("451"), "1볼");
    }

    @Test
    void 볼_2() {
        assertEquals(game.guess("412"), "2볼");
    }

    @Test
    void 볼_3() {
        assertEquals(game.guess("312"), "3볼");

    }

    @Test
    void 스트라이크_1() {
        assertEquals(game.guess("189"), "1스트라이크");
    }

    @Test
    void 스트라이크_2() {
        assertEquals(game.guess("129"), "2스트라이크");
    }

    @Test
    void 스트라이크_3_게임종료() {
        assertEquals(game.guess("123"), "3스트라이크");
        assertTrue(game.isGameEnd());
    }

    @Test
    void 스트라이크_1_볼_1() {
        assertEquals(game.guess("182"), "1스트라이크 1볼");
    }

    @Test
    void 스트라이크_1_볼_2() {
        assertEquals(game.guess("132"), "1스트라이크 2볼");
    }
}