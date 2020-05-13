package exception.ManualLotto;

public class MaximumCountOfManualLottoException extends RuntimeException {
    private static final String MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE = "수동으로 구매하실 수 있는 매수는 최대";

    public MaximumCountOfManualLottoException(String message) {
        super(MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE + message);
    }
}
