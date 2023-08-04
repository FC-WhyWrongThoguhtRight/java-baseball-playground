package calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private String exp;

    public StringCalculator() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            exp = br.readLine();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public int operate() {
        List<String> opers = Arrays.stream(exp.split(" ")).collect(Collectors.toList());
        if (opers.size() % 2 == 0) throw new IllegalArgumentException("식이 올바르지 않습니다");

        while (opers.size() > 1) {
            int operand1 = Integer.parseInt(opers.remove(0));
            String operator = opers.remove(0);
            int operand2 = Integer.parseInt(opers.remove(0));

            int result = calc(operand1, operator, operand2);
            opers.add(0, String.valueOf(result));
        }

        return Integer.parseInt(opers.get(0));
    }

    private int calc(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다");
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("식이 올바르지 않습니다");
        }
    }
}
