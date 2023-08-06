package baseball;

import java.util.Scanner;

public class UserInput {

    Scanner sc;

    int[] input;

    UserInput(Scanner sc){
        input = new int[Game.BALLS_LENGTH.getNum()];
        System.out.print("숫자를 입력해 주세요 : ");
        int num = sc.nextInt();
        setInput(num);
    }

    private void setInput(int num) {
        int index = Game.BALLS_LENGTH.getNum() - 1;
        for(int i = index ; i >= 0 ; i--){
            input[i] = num % 10;
            num /= 10;
        }
    }

    UserInput(int[] input){
        this.input = input;
    }

    public int[] getInput() {
        return this.input;
    }
}
