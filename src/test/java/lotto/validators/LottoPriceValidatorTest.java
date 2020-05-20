package lotto.validators;

import lotto.exceptions.IncorrectInputTypeException;
import lotto.exceptions.IncorrectTotalPriceUnitException;
import lotto.exceptions.IsNotOverZeroException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoPriceValidatorTest {
    @Test
    public void 숫자_입력_아닐_시_예외발생() {
        assertThatExceptionOfType(IncorrectInputTypeException.class)
                .isThrownBy(() -> LottoPriceValidator.test("천원"));
    }

    @Test
    public void 음수입력시_예외_발생() {
        assertThatExceptionOfType(IsNotOverZeroException.class)
                .isThrownBy(() ->LottoPriceValidator.test("-1000"));
    }

    @Test
    public void 구입금액이_로또_가격의_배수가_아니면_예외_발생() {
        assertThatExceptionOfType(IncorrectTotalPriceUnitException.class)
                .isThrownBy(() ->LottoPriceValidator.test("1500"));
    }

}