package game;

import java.util.Scanner;

public class GameConsole {

    private static final boolean GUESS_RIGHT = true;
    private static final boolean GUEST_WRONG = false;
    private static final boolean GAME_ONGOING = true;
    private static final boolean GAME_ENDED = false;

    private Scanner sc;
    private Game game;

    public GameConsole() {
        sc = new Scanner(System.in);
    }

    public void start() {
        game = new Game();

        while (process() == GAME_ONGOING) {
            
        }
    }

    private boolean process() {
        if (play() == GUEST_WRONG) {
            return GAME_ONGOING;
        }

        return askContinue();
    }

    private boolean play() {
        System.out.print("숫자를 입력해 주세요 : ");
        
        String strAnswer = sc.nextLine();
        JudgeResult result = game.judge(strAnswer);
        System.out.println(result);

        if (result.isFullStrike()) {
            return GUESS_RIGHT;
        }
        return GUEST_WRONG;
    }

    private boolean askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        
        String input = sc.nextLine().trim();
        if (input.equals("2")) {
            return GAME_ENDED;
        }
        
        game = new Game();
        return GAME_ONGOING;
    }
}
