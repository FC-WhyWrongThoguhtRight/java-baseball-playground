package baseball;

public class Ball {

    int number;

    Ball(){
        number = makeNumber();
    }

    public Ball(int i) {
        number = i;
    }

    public boolean validateNumber(int number){
        return 0 < number && number < 10;
    }


    public int makeNumber() {
        return (int)(Math.random() * 9 + 1);
    }


    public int getNumber() {
        return number;

    }
}
