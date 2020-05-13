package exception.ManualLotto;

public class LottoNumberOutOfRangeException extends RuntimeException {
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "번호는 1부터 45사이의 숫자여야 합니다.";

    public LottoNumberOutOfRangeException() {
        super(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }
}
