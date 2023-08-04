package study;

import java.util.Stack;

public class StringCalculator {
    public static int calculate(String input) {
        String[] values = input.split(" ");
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = values.length-1; i >= 0; i--) {
            if (isNumber(values[i])) {
                numbers.push(Integer.parseInt(values[i]));
            } else if (isOperator(values[i])) {
                char operator = values[i].charAt(0);
                operators.push(operator);
            }
        }

        while (!operators.isEmpty()) {
            int num2 = numbers.pop();
            int num1 = numbers.pop();
            numbers.push(applyOperator(num1, num2, operators.pop()));
        }

        return numbers.pop();
    }

    private static boolean isNumber(String value) {
        return value.matches("\\d+"); // 숫자 1개 이상을 의미
    }

    private static boolean isOperator(String value) {
        return value.matches("[+\\-*/]"); 
        // - 하이픈은 [a-z] 이런 식으로 역할을 가지기 때문에 백슬리시로 이스케이프해서 사용
    }

    private static int applyOperator(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

