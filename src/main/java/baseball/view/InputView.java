package baseball.view;

import baseball.controller.GAME;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static InputView inputView;
    private static Scanner sc;

    private InputView() {
        sc = new Scanner(System.in);
    }

    public static InputView getInstance(){
        if(inputView == null){
            inputView = new InputView();
        }
        return inputView;
    }

    public int printAndGetInputMsg() {
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextInt();
    }


    public GAME printContinue() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        int input = sc.nextInt();
        if(input == 1){
            return GAME.CONTINUE;
        }
        return GAME.OVER;
    }
}
