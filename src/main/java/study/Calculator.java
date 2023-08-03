package study;

import java.util.Scanner;

public class Calculator {
    private String[] values;

    public Calculator() {
    }

    public Calculator(String value) {
        init(value);
    }

    public void init(String input) {
        if (input == null) {
            throw new IllegalStateException("input이 입력되지 않았습니다.");
        }
        Scanner scanner = new Scanner(input);
        String value = scanner.nextLine();
        values = value.split(" ");
        scanner.close();
    }

    public int cal() {
        Integer result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = procOp(values[i], values[i + 1], result);
        }
        destroy();
        return result;
    }

    private int procOp(String op, String nextVal, Integer currVal) {
        switch (op) {
            case "+":
                currVal += Integer.parseInt(nextVal);
                break;
            case "-":
                currVal -= Integer.parseInt(nextVal);
                break;
            case "*":
                currVal *= Integer.parseInt(nextVal);
                break;
            case "/":
                currVal /= Integer.parseInt(nextVal);
                break;
        }
        return currVal;
    }

    private void destroy() {
        values = null;
    }
}
