package lotto.validators;

import lotto.exceptions.IncorrectInputTypeException;
import lotto.exceptions.IncorrectTotalPriceUnitException;
import lotto.exceptions.IsNotOverZeroException;
import lotto.model.Lotto;

import static lotto.model.Lotto.ZERO;

public class LottoPriceValidator {
    public static void test(String totalPrice) throws Exception {
        if (!totalPrice.matches("[-\\d]+")) {
            throw new IncorrectInputTypeException();
        }
        if (Integer.parseInt(totalPrice) < ZERO) {
            throw new IsNotOverZeroException();
        }
        if (Integer.parseInt(totalPrice) % Lotto.LOTTO_PRICE != ZERO) {
            throw new IncorrectTotalPriceUnitException();
        }
    }
}
