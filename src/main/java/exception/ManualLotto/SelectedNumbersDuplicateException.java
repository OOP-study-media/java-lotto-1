package exception.ManualLotto;

public class SelectedNumbersDuplicateException extends RuntimeException {
    private static final String SELECTED_NUMBER_DUPLICATE_ERROR_MESSAGE = "선택하신 번호에 중복이 있으면 안됩니다.";

    public SelectedNumbersDuplicateException() {
        super(SELECTED_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
}
