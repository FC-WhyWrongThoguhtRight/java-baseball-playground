package baseball;

public enum Game {
    
    BALLS_LENGTH(3),
    COUNTINUED(1),
    END(2);

    private final int number;

    Game(int i) {
        this.number = i;
    }

    public int getNum(){
        return this.number;
    }


}
