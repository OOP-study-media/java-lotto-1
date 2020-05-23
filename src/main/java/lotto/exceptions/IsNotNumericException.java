package lotto.exceptions;

public class IsNotNumericException extends Exception {
    private static final String MESSAGE = "숫자만 입력 가능합니다.";

    public IsNotNumericException() {
        super(MESSAGE);
    }
}
