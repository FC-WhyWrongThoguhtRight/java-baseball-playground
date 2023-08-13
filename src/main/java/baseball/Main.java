package baseball;

import baseball.controller.BaseBall;
import baseball.view.PlayGround;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayGround playGround = new PlayGround(sc);
        playGround.playGame();
    }
}
