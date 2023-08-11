package domain;

import java.util.Random;

public class Balls {
    private final Ball[] balls;
    private final static int MAX_LENGTH = 3;

    public Balls(String... num) {
        assert num.length == MAX_LENGTH;
        balls = new Ball[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            assert num[i].length() == 1;
            balls[i] = new Ball(i, num[i]);
        }
    }

    public Balls(String number) {
        assert number.length() == MAX_LENGTH;
        balls = new Ball[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            balls[i] = new Ball(i, number.charAt(i) + "");
        }
    }

    public Ball[] getBalls() {
        return balls;
    }

    public int[] getResult(Balls balls) {
        int[] result = new int[3];
        for (Ball ball : balls.getBalls()) {
            BallStatus status = getResult(ball);
            result[status.ordinal()]++;
        }
        return result;
    }

    public BallStatus getResult(Ball b) {
        for (Ball ball : balls) {
            BallStatus status = ball.getResult(b);
            if (status != BallStatus.NOTHING) {
                return status;
            }
        }
        return BallStatus.NOTHING;
    }

    public static Balls createRandom() {
        Random rand = new Random();
        int upperBound = (int) Math.pow(10, MAX_LENGTH);
        int randomNumber = rand.nextInt(upperBound);
        while (!isValidNumber(randomNumber)) {
            randomNumber = rand.nextInt(upperBound);
        }
        return new Balls(String.valueOf(randomNumber));
    }

    private static boolean isValidNumber(int number) {
        String str = String.valueOf(number);
        for (String s : str.split("")) {
            if (str.indexOf(s) != str.lastIndexOf(s)) {
                return false;
            }
        }
        return true;
    }
}
