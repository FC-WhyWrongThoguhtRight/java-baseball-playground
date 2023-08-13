package baseball.model;

public class Ball {

    private int index;
    private int number;

    public Ball(int index) {
        this.index = index;
        this.number = makeRandomNumber();
    }

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }


    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    public int makeRandomNumber() {
        return (int)(Math.random() * 9) + 1;
    }


    public boolean numberEquals(Ball ball) {
        return number == ball.getNumber();
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public boolean ballEquals(Ball ball) {
        return index != ball.index && this.number == ball.number;
    }

    public boolean strikeEquals(Ball ball) {
        return index == ball.index && this.number == ball.number;
    }
}
