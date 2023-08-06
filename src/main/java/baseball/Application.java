package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlayGame playGame = new PlayGame();

        while(playGame.isGameContinue()){

            UserInput userInput = new UserInput(sc);

            int strikeCount = playGame.strikeCount(userInput);
            int ballCount = playGame.ballCount(userInput);

            playGame.printResult(strikeCount, ballCount);

            if(playGame.isWin(strikeCount)){
                playGame.printWin();
                playGame.scanContinue(sc);
            }

        }





    }
}
