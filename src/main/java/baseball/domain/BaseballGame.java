package baseball.domain;

import baseball.domain.util.RandomBallsGenerator;

public class BaseballGame {
    private final Balls answer;
    private boolean isGameEnd = false;

    private static final String GAME_END_RESULT = "3스트라이크";

    public BaseballGame() {
        this.answer = RandomBallsGenerator.generate();
    }

    public BaseballGame(Balls answer) {
        this.answer = answer;
    }

    public String guess(String strBallNumbers) {
        JudgeResult result = Judge.judge(answer, new Balls(strBallNumbers));
        if (GAME_END_RESULT.equals(result.toString())) {
            isGameEnd = true;
        }

        return result.toString();
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }
}
