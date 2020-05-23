package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoCreatorTest {
    @Test
    void 로또_번호_랜덤_생성_확인() {
        // given
        List<Integer> randomNumber;
        //when
        randomNumber = RandomLottoNumCreator.getAutoLottoNums();
        //then
        assertThat(randomNumber.size()).isEqualTo(Lotto.LOTTO_LENGTH);
    }
}