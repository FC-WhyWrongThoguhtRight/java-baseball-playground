package game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RandomAnswerGenerator {
    public static Answer generate() {
        List<Integer> balls = Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
            .boxed().collect(Collectors.toList());
        int firstBall = balls.remove(getRandomNumber(0, 8));
        int secondBall = balls.remove(getRandomNumber(0, 7));
        int thirdBall = balls.remove(getRandomNumber(0, 6));

        return new Answer(firstBall, secondBall, thirdBall);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
