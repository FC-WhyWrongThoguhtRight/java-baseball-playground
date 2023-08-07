package baseball;

import java.util.List;

public class ValidationUtils {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int SIZE_NUM = 3;

    public static boolean validNo(int num) {
        return num >= MIN_NUM && num <= MAX_NUM;
    }

    public static boolean duplicatedNo(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public static boolean lengthNo(List<Integer> numbers) {
        return numbers.size() == SIZE_NUM;
    }
}
