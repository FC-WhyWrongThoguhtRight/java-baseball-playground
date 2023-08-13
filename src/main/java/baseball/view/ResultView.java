package baseball.view;

public class ResultView {

    private static ResultView resultView;

    public ResultView() {
    }

    public static ResultView getInstance() {
        if(resultView == null){
            resultView = new ResultView();
        }
        return resultView;
    }

    public void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if(ball > 0){
            sb.append(ball).append("볼 ");
        }
        if(strike > 0){
            sb.append(strike).append("스트라이크");
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }

    public void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
    }


}
