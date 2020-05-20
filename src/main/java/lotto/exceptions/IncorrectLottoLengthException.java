package lotto.exceptions;

import lotto.model.Lotto;

public class IncorrectLottoLengthException extends Exception{
    private static final String MESSAGE = "로또의 길이는" + Lotto.LOTTO_LENGTH +"이어야 합니다. ";

    public IncorrectLottoLengthException() {
        super(MESSAGE);
    }
}
