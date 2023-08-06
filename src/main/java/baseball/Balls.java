package baseball;

public class Balls {

    private final int BALLS_LENGH = 3;

    Ball[] balls;

    Balls(){
        balls = initBalls();
    }

    private Ball[] initBalls() {
        balls = new Ball[BALLS_LENGH];
        makeBalls();
        while(!validateBalls()){
            makeBalls();
        }
        return balls;
    }

    private void makeBalls() {
        for(int i = 0 ; i < BALLS_LENGH ; i++){
            balls[i] = new Ball();
        }
    }


    public int getLength() {
        return balls.length;
    }

    public Ball[] getBalls() {
        return this.balls;
    }

    public boolean validateBalls() {
        return balls[0].getNumber() != balls[1].getNumber()
                && balls[1].getNumber() != balls[2].getNumber()
                && balls[2].getNumber() != balls[0].getNumber();
    }
}
