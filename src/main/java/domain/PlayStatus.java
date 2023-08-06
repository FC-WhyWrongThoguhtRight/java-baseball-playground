package domain;

// play() 메서드를 실행했을때, 결과값을 저장하는 객체
// 스트라이크와 볼의 수로 결정한다.
public class PlayStatus {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }


    public void strikePlus() {
        this.strike++;
    }

    public void ballPlus() {
        this.ball++;
    }
}
