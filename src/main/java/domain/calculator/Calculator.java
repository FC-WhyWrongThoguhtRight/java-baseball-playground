package domain.calculator;

import domain.BaseBallStatus;

public interface Calculator {
    void init();

    BaseBallStatus calculate(String input);
}
