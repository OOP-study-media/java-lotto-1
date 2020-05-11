package model;

import res.Resource;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public static void checkLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != Resource.SELECT_NUMBER_LENGTH) {
            throw new InvalidParameterException(Resource.INVALID_NUMBERS_COUNT_MESSAGE);
        }
    }

    public static void checkManualLottoCount(int total, int manualCount) {
        if (total < manualCount) {
            throw new InvalidParameterException(Resource.INVALID_MANUAL_COUNT_MESSAGE);
        }
    }

    public static void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Resource.INVALID_NUMBER_MESSAGE);
        }
    }

    public static void checkDuplicate(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>(inputNumbers);
        if (numbers.size() != Resource.SELECT_NUMBER_LENGTH) {
            throw new InvalidParameterException(Resource.DUPLICATE_MESSAGE);
        }
    }
}
