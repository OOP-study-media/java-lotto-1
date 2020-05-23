package model;

import res.Resource;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public static void checkLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != Resource.SELECT_NUMBER_LENGTH) {
            throw new InvalidLottoNumbersCountException(Resource.INVALID_NUMBERS_COUNT_MESSAGE);
        }
    }

    public static void checkManualLottoCount(int total, int manualCount) {
        if (total < manualCount) {
            throw new InvalidManualLottoCountException(Resource.INVALID_MANUAL_COUNT_MESSAGE);
        }
    }

    public static void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(Resource.INVALID_NUMBER_MESSAGE);
        }
    }

    public static void checkDuplicate(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>(inputNumbers);
        if (numbers.size() != Resource.SELECT_NUMBER_LENGTH) {
            throw new InvalidNumberSetException(Resource.DUPLICATE_MESSAGE);
        }
    }

    public static class InvalidLottoNumbersCountException extends InvalidParameterException {
        public InvalidLottoNumbersCountException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class InvalidManualLottoCountException extends InvalidParameterException {
        public InvalidManualLottoCountException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class InvalidNumberException extends NumberFormatException {
        public InvalidNumberException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class InvalidNumberSetException extends InvalidParameterException {
        public InvalidNumberSetException(String errorMessage) {
            super(errorMessage);
        }
    }
}
