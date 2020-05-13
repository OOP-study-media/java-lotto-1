package exception.ManualLotto;

public class MinimumCountOfManualLottoException extends RuntimeException {
    private static final String MINIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE = "수동으로 구매하실 매수는 최소 0이상 이어야합니다.";

    public MinimumCountOfManualLottoException() {
        super(MINIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE);
    }
}
