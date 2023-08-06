package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        try {
            Field field = Game.class.getDeclaredField("correctAnswer");
            field.setAccessible(true);

            field.set(game, new Answer(1, 2, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RepeatedTest(value = 100)
    void not_duplicated_random_balls() {
        Game game = new Game();
        
        Answer correctAnswer = null;
        try {
            Field field = Game.class.getDeclaredField("correctAnswer");
            field.setAccessible(true);
            
            correctAnswer = (Answer) field.get(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int[] numbers = null;
        try {
            Method method = Answer.class.getDeclaredMethod("getNumbers");
            method.setAccessible(true);

            numbers = (int[]) method.invoke(correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(numbers[0] == numbers[1], false);
        assertEquals(numbers[0] == numbers[2], false);
        assertEquals(numbers[1] == numbers[2], false);
    }

    @Test
    void judged_ball() {
        assertEquals(game.judge("981").toString(), "1볼");
    }
    
    @Test
    void judged_strike() {
        assertEquals(game.judge("189").toString(), "1스트라이크");
    }
    
    @Test
    void judged_strike_ball() {
        assertEquals(game.judge("139").toString(), "1볼 1스트라이크");
    }
    
    @Test
    void judged_nothing() {
        assertEquals(game.judge("789").toString(), "낫싱");
    }
    
    @Test
    void judged_three_strike() {
        assertEquals(game.judge("123").toString(), "3스트라이크");
    }

    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();
        gameConsole.start();
    }
    
}
