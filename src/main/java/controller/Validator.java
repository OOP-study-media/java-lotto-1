package controller;

import model.Exception;
import ui.Output;

import java.security.InvalidParameterException;
import java.util.List;

public class Validator {
    private static final int EXIT_INVALID_INPUT = 1;

    public static void validateManualCount(int total, int manualCount) {
        try {
            Exception.checkManualLottoCount(total, manualCount);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(EXIT_INVALID_INPUT);
        }
    }

    public static void validateNumber(String number) {
        try {
            Exception.checkNumber(number);
        } catch (NumberFormatException e) {
            Output.printMessage(e.getMessage());
            System.exit(EXIT_INVALID_INPUT);
        }
    }

    public static void validateNumbersCount(List<Integer> numbers) {
        try {
            Exception.checkLottoNumbersCount(numbers);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(EXIT_INVALID_INPUT);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        try {
            Exception.checkDuplicate(numbers);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(EXIT_INVALID_INPUT);
        }
    }
}
