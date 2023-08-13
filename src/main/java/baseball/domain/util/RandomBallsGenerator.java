package baseball.domain.util;

import baseball.domain.Balls;

import java.util.*;

public class RandomBallsGenerator {
    public static Balls generate() {
        Set<Integer> ballNumbers = new HashSet<>();

        while (ballNumbers.size() < 3) {
            int number = generateRandomOneToNine();
            ballNumbers.add(number);
        }

        return new Balls(ballNumbers);
    }

    private static int generateRandomOneToNine() {
        return new Random().nextInt(9) + 1;
    }
}
