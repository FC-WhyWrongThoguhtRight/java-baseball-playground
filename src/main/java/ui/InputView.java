package ui;

import utils.TransformUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static List<Integer> receiveInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = sc.nextLine();

        List<Integer> numbers = TransformUtils.strToList(input);

        return numbers;
    }
}
