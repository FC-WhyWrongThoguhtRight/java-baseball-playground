package baseball.ui;

import baseball.domain.BaseballGame;

public class BaseballConsole {
    private Input in;
    private Output out;
    private BaseballGame game;

    public BaseballConsole(Input in, Output out) {
        this.in = in;
        this.out = out;
        this.game = new BaseballGame();
    }

    public void start() {
        while (!game.isGameEnd()) {
            process();
        }

        askContinue();
    }

    private void process() {
        out.print("숫자를 입력해주세요 : ");

        String input = in.readLine();
        String result = game.guess(input);

        out.println(result);
    }

    private void askContinue() {
        out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");

        String input = null;
        while ("1".equals(input) || "2".equals(input)) {
            out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = in.readLine();
        }

        if ("1".equals(input)) {
            start();
        }
    }
}
