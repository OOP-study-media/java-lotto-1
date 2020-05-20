package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 로또_상금_확인() throws Exception {
        // given
        List<Lotto> lottoRepository = new ArrayList<>();
        lottoRepository.add(LottoCreator.createLotto(Arrays.asList(1,2,3,4,5,6)));

        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer, bonus);

        //when
        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);

        //then
        assertThat(lottoResult.getPrize()).isEqualTo(30_000_000);

    }

}