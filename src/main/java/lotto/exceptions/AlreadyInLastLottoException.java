package lotto.exceptions;

public class AlreadyInLastLottoException extends Exception{
    private static final String MESSAGE = "지난 주 당첨 번호에 보너스가 포함되어 있습니다. ";

    public AlreadyInLastLottoException() {
        super(MESSAGE);
    }
}
