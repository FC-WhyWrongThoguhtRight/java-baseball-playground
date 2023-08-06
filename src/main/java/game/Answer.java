package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Answer {
    
    private int[] numbers;

    public Answer(int firstBall, int secondBall, int thirdBall) {
        numbers = new int[] { firstBall, secondBall, thirdBall };
    }

    public Answer(String answer) {
        this(
            Integer.parseInt(answer.substring(0, 1)),
            Integer.parseInt(answer.substring(1, 2)),
            Integer.parseInt(answer.substring(2, 3))
        );
    }

    public JudgeResult judge(Answer answer) {
        Set<Integer> intersections = getIntersections(answer.getNumbers());
        if (intersections.size() == 0) {
            return new JudgeResult(0, 0);
        }

        int strike = 0;
        int ball = 0;
        for (int intersection : intersections) {
            strike += countStrike(answer.getNumbers(), intersection);
            ball += countBall(answer.getNumbers(), intersection);
        }

        return new JudgeResult(strike, ball);
    }

    private Set<Integer> getIntersections(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(this.numbers)
            .forEach(number -> set.add(number));
        
        Set<Integer> comparedSet = new HashSet<>();
        Arrays.stream(numbers)
            .forEach(number -> comparedSet.add(number));

        set.retainAll(comparedSet);
    
        return set;
    }
    
    private int countStrike(int[] numbers, int intersection) {
        int index = Arrays.binarySearch(this.numbers, intersection);
        int comparedIndex = Arrays.binarySearch(numbers, intersection);

        if (index == comparedIndex) {
            return 1;
        }
        return 0;
    }
    
    private int countBall(int[] numbers, int intersection) {
        int strike = countStrike(numbers, intersection);
        if (strike == 0) {
            return 1;
        }
        return 0;
    }
    
    private int[] getNumbers() {
        return numbers;
    }

}
