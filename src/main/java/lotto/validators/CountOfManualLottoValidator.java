package lotto.validators;

import lotto.exceptions.IncorrectInputTypeException;
import lotto.exceptions.IsNotOverZeroException;
import lotto.exceptions.TooManyManualLottoException;

import static lotto.model.Lotto.ZERO;

public class CountOfManualLottoValidator {
    public static void test(int countOfLotto, String countOfManualLotto) throws Exception {
        if (!countOfManualLotto.matches("[-\\d]+")) {
            throw new IncorrectInputTypeException();
        }

        if (Integer.parseInt(countOfManualLotto) < ZERO) {
            throw new IsNotOverZeroException();
        }

        if (Integer.parseInt(countOfManualLotto) > countOfLotto) {
            throw new TooManyManualLottoException();
        }
    }
}
