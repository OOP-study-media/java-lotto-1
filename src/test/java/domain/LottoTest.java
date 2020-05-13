package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 생성자_테스트() {
        assertThat(lotto).isNotNull();
    }

    @Test
    void 당첨로또와_일치하는_개수_반환_테스트() {
        Lotto winningNumberLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.countMatch(winningNumberLotto)).isEqualTo(6);
    }

    @Test
    void 숫자_포함_테스트() {
        assertThat(lotto.containNumber(1)).isTrue();
        assertThat(lotto.containNumber(7)).isFalse();
    }
}