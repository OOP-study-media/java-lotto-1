package exception.WinningLotto;

public class BonusNumberRangeException extends RuntimeException {
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "보너스 번호는 1부터 45사이의 숫자여야 합니다.";

    public BonusNumberRangeException() {
        super(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
    }
}
