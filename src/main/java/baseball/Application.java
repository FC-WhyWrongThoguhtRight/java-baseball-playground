package baseball;

import baseball.ui.*;

public class Application {
    public static void main(String[] args) {
        Input in = new InputImpl();
        Output out = new OutputImpl();

        BaseballConsole console = new BaseballConsole(in, out);
        console.start();
    }
}
