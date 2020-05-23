package model;

import controller.Validator;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<String> inputNumbers) {
        List<Integer> numbers = makeNumbers(inputNumbers);
        Validator.validateNumbersCount(numbers);
        Validator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> makeNumbers(final List<String> inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            Validator.validateNumber(number);
            numbers.add(Integer.parseInt(number));
        }
        return Collections.unmodifiableList(numbers);
    }

    public String getNumbersToPrint() {
        return numbers.toString();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
