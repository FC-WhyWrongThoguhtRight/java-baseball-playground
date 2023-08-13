package baseball.controller;

import baseball.model.ComputerBalls;
import baseball.model.PlayerBalls;
import baseball.view.ResultView;

import static baseball.controller.Util.BALL_LENGTH;

public class BaseBall {

    ComputerBalls computer;
    private int ballCount;
    private int strikeCount;


    /**
     * 야구를 시작 할때 컴퓨터의 숫자 3개를 정한다.
     */
    public BaseBall() {
        computer = new ComputerBalls();
    }


    public void playBall() {
        PlayerBalls player = null;

        while(!is3Strike()){
            player = new PlayerBalls();

            ballCount = getBallCount(computer, player);
            strikeCount = getStrikeCount(computer, player);

            ResultView.getInstance().printResult(ballCount, strikeCount);
        }

    }

    public int getBallCount(ComputerBalls computer, PlayerBalls player) {
        int count = 0;

        for(int i = 0 ; i < BALL_LENGTH ; i++){
            count += computer.hasBall(player.getBall(i));
        }

        return count;
    }


    public int getStrikeCount(ComputerBalls computer, PlayerBalls player) {
        int count = 0;
        for(int i = 0 ; i < BALL_LENGTH ; i++){
            if(computer.getBall(i).strikeEquals(player.getBall(i)))
                count += 1;
        }
        return count;
    }

    public boolean is3Strike() {
        return this.strikeCount == 3;
    }

}
