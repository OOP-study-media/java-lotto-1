package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class WinningLottoTest {

    @Test
    void 랭크_1등_2등_3등_잘_계산하고_맵으로_잘_나오는지_테스트() {
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");

        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), 7);
        List<Lotto> lottoTickets = new ArrayList<>();

        List<String> numbers1 = new ArrayList<>();
        numbers1.add("1");
        numbers1.add("2");
        numbers1.add("3");
        numbers1.add("4");
        numbers1.add("5");
        numbers1.add("6");
        lottoTickets.add(new Lotto(numbers1));

        List<String> numbers2 = new ArrayList<>();
        numbers2.add("1");
        numbers2.add("2");
        numbers2.add("3");
        numbers2.add("4");
        numbers2.add("5");
        numbers2.add("7");
        lottoTickets.add(new Lotto(numbers2));

        List<String> numbers3 = new ArrayList<>();
        numbers3.add("1");
        numbers3.add("2");
        numbers3.add("3");
        numbers3.add("4");
        numbers3.add("5");
        numbers3.add("8");
        lottoTickets.add(new Lotto(numbers3));

        TreeMap<Rank, Integer> rankCount = winningLotto.getRankCount(lottoTickets);
        assertThat(rankCount).hasSize(6)
                .contains(entry(Rank.FIRST, 1), entry(Rank.SECOND, 1), entry(Rank.THIRD, 1))
                .doesNotContain(entry(Rank.FOURTH, 1), entry(Rank.FIFTH, 1));

    }
}
