package lotto.model;

import lotto.exceptions.IncorrectLottoLengthException;
import lotto.exceptions.IncorrectLottoRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCreatorTest {
    @Test
    void 올바른_로또_번호_주입_시_로또_생성() throws Exception {
        // given
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        Lotto lotto = LottoCreator.createLotto(lottoNum);
        // then
        assertThat(lotto.getNumbers()).isNotNull()
                .isEqualTo(lottoNum);
    }

    @Test
    void 잘못된_길이의_로또번호_주입_시_예외_발생() throws Exception {
        assertThatExceptionOfType(IncorrectLottoLengthException.class)
                .isThrownBy(() -> LottoCreator.createLotto(Arrays.asList(1, 2, 3)));
    }

    @Test
    void 잘못된_범위의_로또_번호_주입_시_예외_발생() throws Exception {
        assertThatExceptionOfType(IncorrectLottoRangeException.class)
                .isThrownBy(() -> LottoCreator.createLotto(Arrays.asList(0, 46, 47, 48, 49, 50)));
    }

}
