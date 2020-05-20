package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RankCountTest {
    @Test
    void 랭크_개수_카운트_확인() throws Exception {
        // given
        RankCount rankCount;
        List<Lotto> lottoRepository = new ArrayList<>();
        lottoRepository.add(LottoCreator.createLotto(Arrays.asList(1,2,3,4,5,6)));

        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer, bonus);

        // when
        rankCount = new RankCount(lottoRepository, winningLotto);

        //then
        List<Rank> countOfRankIsOne = rankCount.getResult().entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertThat(countOfRankIsOne).containsOnly(Rank.SECOND);

    }

}