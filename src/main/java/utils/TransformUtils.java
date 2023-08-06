package utils;

import java.util.ArrayList;
import java.util.List;

public class TransformUtils {
    public static List<Integer> strToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            numbers.add(input.charAt(i)-'0');
        }
        return numbers;
    }
}
