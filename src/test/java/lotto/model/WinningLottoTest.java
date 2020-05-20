package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @Test
    void 정답비교_후_반환되는_Rank_값_확인() {
        // given
        Lotto myLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1,2,3,4,5,45));
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer, 6);
        // when
        Rank result = winningLotto.match(myLotto);
        // then
        assertThat(result).isEqualTo(Rank.SECOND);
    }

}