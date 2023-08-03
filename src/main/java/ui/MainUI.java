package ui;

import domain.BaseBallStatus;
import domain.calculator.Calculator;
import domain.calculator.CalculatorImpl;

import java.util.Scanner;

public class MainUI {
    private static MainUI instance;

    private Scanner sc;
    private Calculator calculator;

    private MainUI(Scanner sc, Calculator calculator) {
        this.sc = sc;
        this.calculator = calculator;
    }

    public static MainUI getInstance() {
        if (instance == null) {
            instance = new MainUI(new Scanner(System.in), new CalculatorImpl());
        }
        return instance;
    }

    public void service() {
        calculator.init();
        BaseBallStatus status = BaseBallStatus.CONTINUE;
        while (isPersist(status)) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = sc.next();
            status = calculator.calculate(input);
            print(status);
        }
        exit();
    }

    private void print(BaseBallStatus status) {
        String result = "";

        if (status.getBall() > 0) {
            result += status.getBall() + "볼 ";
        }
        if (status.getStrike() > 0) {
            result += status.getStrike() + "스트라이크 ";
        }
        if (status.getStrike() == 0 && status.getBall() == 0) {
            result += "낫싱";
        }

        System.out.println(result);
    }

    private boolean isPersist(BaseBallStatus status) {
        if (status == BaseBallStatus.DONE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int again = sc.nextInt();
            if (again == 1) {
                calculator.init();
                return true;
            }
            if (again == 2) {
                return false;
            }
        }
        return true;
    }

    private void exit() {
        System.exit(0);
    }
}
