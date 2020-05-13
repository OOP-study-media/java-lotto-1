package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @Test
    void 랜덤숫자_생성_테스트() {
        //given
        int number;
        //when
        number = RandomNumberGenerator.generateRandomNumber();
        //then
        assertThat(number).isBetween(1, 45);
    }
}