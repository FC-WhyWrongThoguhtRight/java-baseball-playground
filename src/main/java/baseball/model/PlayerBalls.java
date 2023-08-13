package baseball.model;

import baseball.view.InputView;

import static baseball.controller.Util.BALL_LENGTH;

public class PlayerBalls implements Balls{

    Ball[] balls;

    public PlayerBalls() {
        this.balls = createBalls();
    }

    @Override
    public Ball[] createBalls() {
        InputView inputView = InputView.getInstance();
        int input = inputView.printAndGetInputMsg();

        Ball[] inputs = new Ball[BALL_LENGTH];
        inputs[0] = new Ball(0,input / 100);
        inputs[1] = new Ball(1,(input % 100) / 10);
        inputs[2] = new Ball(2,input % 10);

        return inputs;
    }

    @Override
    public Ball getBall(int index) {
        return this.balls[index];
    }
}
