package lotto.validators;

import lotto.exceptions.IsNotNumericException;
import lotto.exceptions.IncorrectTotalPriceUnitException;
import lotto.exceptions.IsNotOverZeroException;
import lotto.model.Lotto;

import static lotto.model.Lotto.ZERO;

public class LottoPriceValidator {
    public static void validate(String totalPrice) throws Exception {
        if (!totalPrice.matches("[-\\d]+")) {
            throw new IsNotNumericException();
        }
        if (Integer.parseInt(totalPrice) < ZERO) {
            throw new IsNotOverZeroException();
        }
        if (Integer.parseInt(totalPrice) % Lotto.LOTTO_PRICE != ZERO) {
            throw new IncorrectTotalPriceUnitException();
        }
    }
}
