package dispatcher;

import domain.Balls;
import handler.BaseBallHandler;
import view.ModelView;
import view.Viewer;

import java.lang.reflect.InvocationTargetException;

public class Dispatcher {
    private final BaseBallHandler baseBallHandler;
    private final Viewer viewer;

    private ThreadLocal<Balls> ansBall = new ThreadLocal<>();

    private static final Dispatcher instance = new Dispatcher(BaseBallHandler.getInstance(), Viewer.getInstance());

    private Dispatcher(BaseBallHandler baseBallHandler, Viewer viewer) {
        this.baseBallHandler = baseBallHandler;
        this.viewer = viewer;
    }

    public static Dispatcher getInstance() {
        return instance;
    }

    public void service() throws InvocationTargetException, IllegalAccessException {
        while (true) {
            if (ansBall.get() == null) {
                ansBall.set(Balls.createRandom());
            }
            Balls balls = viewer.getBalls();
            ModelView mv = baseBallHandler.handle(balls, ansBall);
            mv.render();
        }
    }
}
