package domain;

import java.util.ArrayList;
import java.util.List;

// 객체 Ball를 묶은 객체 Balls (3개의 Ball)
public class Balls {

    private final List<Ball> balls;

    // 생성자
    public Balls(List<Integer> ballNumbers) {
        balls = mapBalls(ballNumbers);
    }

    // 입력받은 랜덤숫자가 List<Integer> 형태로 들어오면 그것을 List<Ball> 형태로 만들어서 반환해주는 메서드
    private List<Ball> mapBalls(List<Integer> ballNumbers) {
        List<Ball> tmpBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmpBalls.add(new Ball(i+1, ballNumbers.get(i)));
        }
        return tmpBalls;
    }
    
    // 컴퓨터의 3자리 수가 주어지고, 사용자의 수가 1개 주어졌을때, 1개에 대한 결과값을 반환해주는 메서드
    public BallStatus playBall(Ball userBall) {
        return balls.stream()
                .map(computerBall -> computerBall.judge(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}