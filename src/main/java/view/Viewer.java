package view;

import domain.BallStatus;
import domain.Balls;

import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Viewer {
    private final Scanner sc = new Scanner(System.in);

    private static final Viewer instance = new Viewer();

    private Viewer() {
    }

    public static Viewer getInstance() {
        return instance;
    }

    public Balls getBalls() {
        System.out.print("숫자를 입력해 주세요 : ");
        String s = sc.next();
        return new Balls(s.split(""));
    }

    public void showResult(int[] result) {
        StringBuffer sb = new StringBuffer();
        if (result[BallStatus.BALL.ordinal()] > 0) {
            sb.append(result[BallStatus.BALL.ordinal()] + "볼 ");
        }
        if (result[BallStatus.STRIKE.ordinal()] > 0) {
            sb.append(result[BallStatus.STRIKE.ordinal()] + "스트라이크 ");
        }
        if (result[BallStatus.STRIKE.ordinal()] == 0 && result[BallStatus.BALL.ordinal()] == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    public void showFinish(int[] result) throws UnexpectedException {
        if (result[BallStatus.STRIKE.ordinal()] != 3) {
            throw new UnexpectedException("올스트라이크 아닌데 호출됨;;");
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int again = sc.nextInt();
        if (again == 1) {
            return;
        }
        if (again == 2) {
            System.exit(0);
        }
        throw new IllegalArgumentException("1 또는 2를 입력해주세요");
    }
}
