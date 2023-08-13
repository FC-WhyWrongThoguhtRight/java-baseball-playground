package baseball.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputImpl implements Input{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
