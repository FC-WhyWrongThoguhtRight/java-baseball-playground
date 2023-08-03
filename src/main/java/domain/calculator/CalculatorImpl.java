package domain.calculator;

import domain.BaseBallStatus;

import java.util.Random;

public class CalculatorImpl implements Calculator {
    private String number;
    private final int LENGTH = 3;

    @Override
    public void init() {
        Random rand = new Random();
        int upperBound = (int) Math.pow(10, LENGTH);
        int randomNumber = rand.nextInt(upperBound);
        while (!isValidNumber(randomNumber)) {
            randomNumber = rand.nextInt(upperBound);
        }
        number = String.valueOf(randomNumber);
    }

    private boolean isValidNumber(int number) {
        String str = String.valueOf(number);
        for (String s : str.split("")) {
            if (str.indexOf(s) != str.lastIndexOf(s)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public BaseBallStatus calculate(String input) {
        int[] result = getResult(input);
        if (result[0] == 3) {
            return BaseBallStatus.DONE;
        }
        BaseBallStatus.CONTINUE.setStrike(result[0]);
        BaseBallStatus.CONTINUE.setBall(result[1]);
        return BaseBallStatus.CONTINUE;
    }

    private int[] getResult(String input) {
        int all = getAll(input);
        int strike = getStrike(input);
        int ball = all - strike;

        return new int[]{strike, ball};
    }

    private int getStrike(String input) {
        int result = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (number.charAt(i) == input.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    private int getAll(String input) {
        int result = 0;
        for (String s : input.split("")) {
            if (number.contains(s)) {
                result++;
            }
        }
        return result;
    }
}
