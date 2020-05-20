package lotto.model;

import org.junit.jupiter.api.Test;
import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RankTest {
    private Rank rank;

    @Test
    void 일등_당첨_확인() {
        // when
        rank = Rank.valueOf(6, false);
        // then
        assertThat(rank).isEqualTo(FIRST);
    }

    @Test
    void 이등_당첨_확인() {
        // when
        rank = Rank.valueOf(5, true);
        // then
        assertThat(rank).isEqualTo(SECOND);
    }

    @Test
    void 삼등_당첨_확인() {
        // when
        rank = Rank.valueOf(5, false);
        // then
        assertThat(rank).isEqualTo(THIRD);
    }

    @Test
    void 사등_당첨_확인() {
        // when
        rank = Rank.valueOf(4, false);
        // then
        assertThat(rank).isEqualTo(FOURTH);
    }

    @Test
    void 오등_당첨_확인() {
        // when
        rank = Rank.valueOf(3, false);
        // then
        assertThat(rank).isEqualTo(FIFTH);
    }

    @Test
    void 미당첨_당첨_확인() {
        // when
        rank = Rank.valueOf(0, false);
        // then
        assertThat(rank).isEqualTo(MISS);
    }

    @Test
    void 최대범위_밖의_인풋_확인() {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            rank = Rank.valueOf(7, false);
        });
    }

}