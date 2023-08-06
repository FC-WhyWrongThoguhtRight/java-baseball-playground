package game;

public class Game {
    private Answer correctAnswer;

    public Game() {
        correctAnswer = RandomAnswerGenerator.generate();
    }

    public JudgeResult judge(String strAnswer) {
        return correctAnswer.judge(new Answer(strAnswer));
    }

}
