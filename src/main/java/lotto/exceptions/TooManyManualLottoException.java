package lotto.exceptions;

public class TooManyManualLottoException extends Exception {
    private static final String TOO_MANY_MANUAL_LOTTO = "수동 로또 개수가 전체 로또 개수보다 많습니다.";

    public TooManyManualLottoException() {
        super(TOO_MANY_MANUAL_LOTTO);
    }
}
