package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 두_로또_일치하는_숫자_개수_확인() {
        // given 
        Lotto a = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto b = new Lotto(Arrays.asList(4,5,6,7,8,9));
        // when
        int countOfMatch = a.countOfMatch(b);
        // then
        assertThat(countOfMatch).isEqualTo(3);
    }

    @Test
    void 특정_숫자가_로또안에_있는_지_확인() {
        // given
        Lotto a = new Lotto(Arrays.asList(1,2,3,4,5,6));
        // when
        boolean result = a.containNumber(1);
        // then
        assertThat(result).isTrue();
    }

}