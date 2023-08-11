package handler;

import domain.BallStatus;
import domain.Balls;
import view.ModelView;
import view.ViewName;

public class BaseBallHandler {
    private static final BaseBallHandler instance = new BaseBallHandler();

    private BaseBallHandler() {
    }

    public static BaseBallHandler getInstance() {
        return instance;
    }


    public ModelView handle(Balls balls, ThreadLocal<Balls> ansBalls) {
        int[] result = ansBalls.get().getResult(balls);
        if (result[BallStatus.STRIKE.ordinal()] == 3) {
            ansBalls.remove();
            return new ModelView(ViewName.showFinish, result);
        }
        return new ModelView(ViewName.showResult, result);
    }
}
