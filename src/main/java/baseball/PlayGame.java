package baseball;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class PlayGame {

    Balls balls;
    Game continueFlag;

    PlayGame(){
        balls = new Balls();
        setGameFlag(Game.COUNTINUED);
    }

    public PlayGame(int[] ints) {
        balls = new Balls(ints);
        setGameFlag(Game.COUNTINUED);
    }

    public int strikeCount(UserInput userInput) {
        return balls.getStrikeCount(userInput.getInput());
    }

    public int ballCount(UserInput userInput) {
        return balls.getBallCount(userInput.getInput());
    }


    public boolean isWin(int strikeCount) {
        return strikeCount == 3;
    }

    public void setGameFlag(Game game){
        continueFlag = game;
    }

    public boolean isGameContinue() {
       return Game.COUNTINUED.equals(continueFlag);
    }

    public void printResult(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if(ballCount + strikeCount == 0){
            sb.append("낫씽");
        }
        if(ballCount > 0){
            sb.append(ballCount).append("볼");
        }
        if(ballCount > 0 && strikeCount > 0){
            sb.append(" ");
        }
        if(strikeCount > 0){
            sb.append(strikeCount).append("스트라이크");
        }

        System.out.println(sb.toString());
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void scanContinue(Scanner sc) {
        int flag = sc.nextInt();
        setGameFlag(flag == 1 ? Game.COUNTINUED : Game.END);
    }
}
