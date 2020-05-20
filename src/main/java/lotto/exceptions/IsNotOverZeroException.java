package lotto.exceptions;

public class IsNotOverZeroException extends Exception{
    private static final String PLEASE_ENTER_OVER_ZERO = "0 이상의 정수로 입력해 주세요.";

    public IsNotOverZeroException() {
        super(PLEASE_ENTER_OVER_ZERO);
    }
}
