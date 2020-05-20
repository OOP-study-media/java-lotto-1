package lotto.validators;

import lotto.exceptions.IncorrectInputTypeException;
import lotto.exceptions.IsNotOverZeroException;
import lotto.exceptions.TooManyManualLottoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CountOfManualLottoValidatorTest {
    @Test
    public void 숫자_입력_아닐_시_예외발생() {
        assertThatExceptionOfType(IncorrectInputTypeException.class)
                .isThrownBy(() -> CountOfManualLottoValidator.test(10, "다섯개"));
    }

    @Test
    public void 음수입력시_예외_발생() {
        assertThatExceptionOfType(IsNotOverZeroException.class)
                .isThrownBy(() ->CountOfManualLottoValidator.test(10, "-1"));
    }

    @Test
    public void 전체로또보다_수동로또가_많으면_예외_발생() {
        assertThatExceptionOfType(TooManyManualLottoException.class)
                .isThrownBy(() ->CountOfManualLottoValidator.test(10, "11"));
    }

}