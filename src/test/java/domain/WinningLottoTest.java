package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private Lotto winningNumbersLotto;
    private int bonus;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        winningNumbersLotto = LottoGenerator.generateLotto(numbers);
        bonus = 7;
        winningLotto = new WinningLotto(winningNumbersLotto, bonus);
    }

    @Test
    void 생성자_테스트() {
        WinningLotto target = new WinningLotto(winningNumbersLotto, bonus);
        assertThat(winningLotto.equals(winningLotto)).isTrue();
    }

    @Test
    void 당첨번호와_매치_테스트() {
        assertThat(winningLotto.match(winningNumbersLotto)).isEqualTo(Rank.FIRST);
    }
}