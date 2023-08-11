package handler;

import domain.Balls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ModelView;
import view.ViewName;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallHandlerTest {
    private ThreadLocal<Balls> ansBalls;

    @BeforeEach
    void init() {
        ansBalls = new ThreadLocal<>();
        ansBalls.set(Balls.createRandom());
    }

    @AfterEach
    void destroy() {
        ansBalls.remove();
    }

    @Test
    void strikesTest() throws NoSuchFieldException, IllegalAccessException {
        Balls balls = new Balls("1", "2", "3");
        ansBalls.set(new Balls("1", "2", "3"));

        BaseBallHandler handler = BaseBallHandler.getInstance();
        ModelView mv = handler.handle(balls, ansBalls);

        Field viewName = ModelView.class.getDeclaredField("viewName");
        viewName.setAccessible(true);
        assertThat(((ViewName)viewName.get(mv)).name()).isEqualTo("showFinish");
    }

    @Test
    void ballsTest() throws NoSuchFieldException, IllegalAccessException {
        Balls balls = new Balls("3", "1", "2");
        ansBalls.set(new Balls("1", "2", "3"));

        BaseBallHandler handler = BaseBallHandler.getInstance();
        ModelView mv = handler.handle(balls, ansBalls);

        Field viewName = ModelView.class.getDeclaredField("viewName");
        viewName.setAccessible(true);
        assertThat(((ViewName)viewName.get(mv)).name()).isEqualTo("showResult");
    }

    @Test
    void nothingTest() throws NoSuchFieldException, IllegalAccessException {
        Balls balls = new Balls("4", "5", "6");
        ansBalls.set(new Balls("1", "2", "3"));

        BaseBallHandler handler = BaseBallHandler.getInstance();
        ModelView mv = handler.handle(balls, ansBalls);

        Field viewName = ModelView.class.getDeclaredField("viewName");
        viewName.setAccessible(true);
        assertThat(((ViewName)viewName.get(mv)).name()).isEqualTo("showResult");
    }
}
