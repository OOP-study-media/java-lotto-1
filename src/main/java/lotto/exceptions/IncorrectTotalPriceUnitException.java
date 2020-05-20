package lotto.exceptions;

import lotto.model.Lotto;

public class IncorrectTotalPriceUnitException extends Exception{
    private static final String MESSAGE = "구입 금액은 " + Lotto.LOTTO_PRICE + "단위로 입력해 주세요. ";

    public IncorrectTotalPriceUnitException() {
        super(MESSAGE);
    }
}
