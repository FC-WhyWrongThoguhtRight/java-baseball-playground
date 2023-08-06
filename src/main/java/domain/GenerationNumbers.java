package domain;

import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerationNumbers {
    public List<Integer> randomNumbers() {
        Set<Integer> computerNumbers = new HashSet<>();
        while(ValidationUtils.validSize(computerNumbers)) {
            int number = (int)(Math.random()*9)+1;
            computerNumbers.add(number);
        }
        return new ArrayList<>(computerNumbers);
    }
}
