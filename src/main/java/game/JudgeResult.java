package game;

public class JudgeResult {

    private int strike;
    private int ball;

    public JudgeResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
    
    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        String ballResult = getBallResult();
        String strikeResult = getStrikeResult();

        if (!ballResult.isEmpty() && !strikeResult.isEmpty()) {
            return ballResult + " " + strikeResult;
        }
        
        return ballResult + strikeResult;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private String getBallResult() {
        if (ball == 0) {
            return "";
        }
        return ball + "볼";
    }

    private String getStrikeResult() {
        if (strike == 0) {
            return "";
        }
        return strike + "스트라이크";
    }

    public boolean isFullStrike() {
        return strike == 3;
    }

}
