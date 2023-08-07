package baseball.controller;

import baseball.service.PlayService;

import java.util.List;

public class PlayController {

    PlayService playService = new PlayService();

    public void startGame() {
        List<Integer> answer = playService.creteRandom();
        boolean pass = false;

        while (true) {
            pass = playService.startGame(answer);
            if (pass) {
                answer = playService.creteRandom();
                playService.endGame();
            }
        }
    }


}
