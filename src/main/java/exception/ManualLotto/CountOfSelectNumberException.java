package exception.ManualLotto;

public class CountOfSelectNumberException extends RuntimeException {
    private static final String SELECTED_NUMBER_COUNT_ERROR_MEESAGE = "번호는 6개를 입력해 주셔야 합니다.";

    public CountOfSelectNumberException() {
        super(SELECTED_NUMBER_COUNT_ERROR_MEESAGE);
    }
}
