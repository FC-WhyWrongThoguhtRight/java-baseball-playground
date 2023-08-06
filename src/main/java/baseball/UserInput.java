package baseball;

import java.util.Scanner;

public class UserInput {

    Scanner sc;

    int input;

    UserInput(){
        sc = new Scanner(System.in);
        input = sc.nextInt();
    }

    public int getInput() {
        return this.input;
    }
}
