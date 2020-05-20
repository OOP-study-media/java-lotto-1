package lotto.validators;

import lotto.exceptions.IncorrectLottoLengthException;
import lotto.exceptions.IncorrectLottoRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberValidatorTest {

    @Test
    public void 로또_넘버_길이_테스트() {
        assertThatExceptionOfType(IncorrectLottoLengthException.class)
                .isThrownBy(() -> LottoNumberValidator.test(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void 로또_넘버_범위_테스트() {
        assertThatExceptionOfType(IncorrectLottoRangeException.class)
                .isThrownBy(() -> LottoNumberValidator.test(Arrays.asList(0, 45, 46, 47, 48, 49)));
    }

}