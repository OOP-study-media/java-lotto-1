package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void rank_3등_잘_계산하는지_테스트() {
        // given
        int countOfMatch = 5;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @Test
    void rank_2등_잘_계산하는지_테스트() {
        // given
        int countOfMatch = 5;

        // when
        Rank rank = Rank.valueOf(countOfMatch, true);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }
}
