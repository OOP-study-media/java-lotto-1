package lotto.validators;

import lotto.exceptions.AlreadyInLastLottoException;
import lotto.exceptions.IncorrectLottoRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberValidatorTest {
    @Test
    public void 보너스번호_당첨번호에_있으면_예외발생() {
        assertThatExceptionOfType(AlreadyInLastLottoException.class)
                .isThrownBy(() -> BonusNumberValidator.test(Arrays.asList(1, 2, 3, 4, 5, 6), 1));
    }

    @Test
    public void 보너스번호_범위_체크() {
        assertThatExceptionOfType(IncorrectLottoRangeException.class)
                .isThrownBy(() -> BonusNumberValidator.test(Arrays.asList(1, 2, 3, 4, 5, 6), 50));
    }
}