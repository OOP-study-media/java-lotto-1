package lotto.exceptions;

import lotto.model.Lotto;

public class IncorrectLottoRangeException extends Exception{
    private static final String MESSAGE = "로또 번호는 " + Lotto.LOTTO_MIN_VALUE +"~" + Lotto.LOTTO_MAX_VALUE+ " 사이로 입력해 주세요. ";

    public IncorrectLottoRangeException() {
        super(MESSAGE);
    }
}
