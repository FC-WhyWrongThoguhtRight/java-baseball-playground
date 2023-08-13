package baseball.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {
    private Ball[] balls;

    public Balls(String strBallNumbers) throws IllegalArgumentException {
        strBallNumbers = strBallNumbers.trim();
        validate(strBallNumbers);

        balls = toBalls(strBallNumbers);
    }

    private void validate(String strBallNumbers) throws IllegalArgumentException {
        int[] ballNumbers = Arrays.stream(strBallNumbers.split("")).mapToInt(Integer::parseInt).toArray();
        boolean duplicated = ballNumbers[0] == ballNumbers[1] || ballNumbers[0] == ballNumbers[2] || ballNumbers[1] == ballNumbers[2];

        if (duplicated) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야 합니다.");
        }
    }

    private Ball[] toBalls(String strBallNumbers) {
        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(strBallNumbers.split("")).mapToInt(Integer::parseInt).mapToObj(ballNumber -> new Ball(index.getAndIncrement(), ballNumber)).toArray(Ball[]::new);
    }

    public Balls(Set<Integer> ballNumbers) {
        String strBallNumbers = ballNumbers.stream().map(String::valueOf).collect(Collectors.joining());
        validate(strBallNumbers);

        this.balls = toBalls(strBallNumbers);
    }

    public Ball[] getBalls() {
        return this.balls;
    }
}
