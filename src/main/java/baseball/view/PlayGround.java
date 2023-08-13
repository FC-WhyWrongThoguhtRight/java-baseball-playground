package baseball.view;

import baseball.controller.BaseBall;
import baseball.controller.GAME;

import java.util.Scanner;

public class PlayGround {

    BaseBall baseBall;

    InputView inputView;
    ResultView resultView;

    Scanner sc;

    private GAME gameContinue;

    public PlayGround(Scanner sc) {
        this.sc = sc;
        inputView = InputView.getInstance();
        resultView = ResultView.getInstance();
        gameContinue = GAME.CONTINUE;
    }


    /**
     * 프로그램 시작, 야구를 실행하고, 야구가 끝나면 프로그램 지속을 정한다.
     */
    public void playGame(){
        while(isGameContinue()){
            playBaseBall();
            gameContinue = inputView.printContinue();
        }
    }

    /**
     * 야구 시작! 숫자야구를 시작한다.
     */
    private void playBaseBall() {
        baseBall = new BaseBall();
        baseBall.playBall();
        resultView.printGameOver();
    }

    public boolean isGameContinue() {
        return this.gameContinue == GAME.CONTINUE;
    }

}
