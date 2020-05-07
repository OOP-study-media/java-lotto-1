package model;

import res.Resource;
import ui.Output;

import java.security.InvalidParameterException;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<String> inputNumbers) {
        List<Integer> numbers = makeNumbers(inputNumbers);
        validateNumbersCount(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> makeNumbers(final List<String> inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            validateNumber(number);
            numbers.add(Integer.parseInt(number));
        }
        return Collections.unmodifiableList(numbers);
    }

    private void validateNumber(String number) {
        try {
            Validator.checkNumber(number);
        } catch (NumberFormatException e) {
            Output.printMessage(e.getMessage());
            System.exit(Resource.EXIT_INVALID_INPUT);
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
        try {
            Validator.checkLottoNumbersCount(numbers);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(Resource.EXIT_INVALID_INPUT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        try {
            Validator.checkDuplicate(numbers);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(Resource.EXIT_INVALID_INPUT);
        }
    }

    public static List<String> getRandomNumbers() {
        Random random = new Random();
        Set<String> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < Resource.SELECT_NUMBER_LENGTH) {
            String number = random.nextInt(Resource.RANGE) + 1 + "";
            randomNumbers.add(number);
        }
        return new ArrayList<>(randomNumbers);
    }

    public void printNumbers() {
        Output.printMessage(numbers.toString());
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
