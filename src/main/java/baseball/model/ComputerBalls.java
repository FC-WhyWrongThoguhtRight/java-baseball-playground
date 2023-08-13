package baseball.model;

import baseball.view.InputView;


import static baseball.controller.Util.BALL_LENGTH;

public class ComputerBalls implements Balls {

    Ball[] balls;

    public ComputerBalls() {
        balls = createBalls();
    }

    @Override
    public Ball[] createBalls() {
        balls = new Ball[BALL_LENGTH];

        balls[0] = new Ball(0);

        for(int i = 1 ; i < BALL_LENGTH; i++){
            balls[i] = new Ball(i);
            if(balls[i-1].numberEquals(balls[i])){
                i--;
            }
        }
        return balls;
    }

    @Override
    public Ball getBall(int index) {
        return this.balls[index];
    }


    public int hasBall(Ball ball){

        int count = 0;
        for(Ball b : balls){
            if(b.ballEquals(ball)){
                count += 1;
            }
        }

        return count;
    }


    public int ballsSize() {
        return balls.length;
    }

    public Ball getNumber(int index) {
        return this.balls[index];
    }
}
