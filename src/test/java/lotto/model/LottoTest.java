package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 두_로또_일치하는_숫자_개수_확인() throws Exception {
        // given 
        Lotto standard = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto target = new Lotto(Arrays.asList(4,5,6,7,8,9));
        // when
        int countOfMatch = standard.countOfMatch(target);
        // then
        assertThat(countOfMatch).isEqualTo(3);
    }

    @Test
    void 특정_숫자가_로또안에_있는_지_확인() throws Exception {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        // when
        boolean result = lotto.containNumber(1);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void 특정_숫자가_로또안에_없는_지_확인() throws Exception {
        // given
        Lotto a = new Lotto(Arrays.asList(1,2,3,4,5,6));
        // when
        boolean result = a.containNumber(8);
        // then
        assertThat(result).isFalse();
    }

}