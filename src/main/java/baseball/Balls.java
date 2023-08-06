package baseball;

public class Balls {

    Ball[] balls;

    Balls(){
        balls = initBalls();
    }

    public Balls(int[] ints) {
        balls = new Ball[Game.BALLS_LENGTH.getNum()];
        for(int i = 0; i < Game.BALLS_LENGTH.getNum() ; i++){
            balls[i] = new Ball(ints[i]);
        }
    }

    private Ball[] initBalls() {
        balls = new Ball[Game.BALLS_LENGTH.getNum()];
        makeBalls();
        while(!validateBalls()){
            makeBalls();
        }
        return balls;
    }

    private void makeBalls() {
        for(int i = 0 ; i < Game.BALLS_LENGTH.getNum() ; i++){
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

    public int getStrikeCount(int[] input) {
        int count = 0;
        for(int i = 0 ; i < Game.BALLS_LENGTH.getNum() ; i++){
            count += input[i] == balls[i].getNumber() ? 1 : 0;
        }
        return count;
    }

    public int getBallCount(int[] input) {

        int count = 0;
        if(input[0] == balls[1].getNumber() || input[0] == balls[2].getNumber()){
            count += 1;
        }
        if(input[1] == balls[0].getNumber() || input[1] == balls[2].getNumber()){
            count += 1;
        }
        if(input[2] == balls[0].getNumber() || input[0] == balls[1].getNumber()){
            count += 1;
        }

        return count;
    }
}
