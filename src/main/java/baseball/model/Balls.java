package baseball.model;

import static baseball.controller.Util.BALL_LENGTH;

public interface Balls {

    Ball[] createBalls();
    Ball getBall(int index);



}
