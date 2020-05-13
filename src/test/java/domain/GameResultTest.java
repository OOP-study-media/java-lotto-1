package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult result;

    @BeforeEach
    void setUp() {
        int countOfPurchaseLotto = 5;
        LottoRepository lottoRepository = new LottoRepository();
        WinningLotto winningLotto;

        lottoRepository.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoRepository.addLotto(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        lottoRepository.addLotto(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        lottoRepository.addLotto(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        lottoRepository.addLotto(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)));

        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        result = new GameResult(lottoRepository, countOfPurchaseLotto, winningLotto);
    }

    @Test
    void 당첨결과가_1등부터_미당첨까지_포함하는지_테스트() {
        assertThat(result.getResult().size()).isEqualTo(6);
    }

    @Test
    void 올바른_결과_생성_테스트() {
        IntStream.range(0, 6).forEach(i -> {
            if (i == 2) {
                return;
            }
            assertThat(result.getResult().get(Rank.values()[i])).isEqualTo(1);
        });
        assertThat(result.getResult().get(Rank.values()[2])).isEqualTo(0);
    }
}