package model;

import org.junit.jupiter.api.Test;
import res.Resource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {

    @Test
    void 랜덤_숫자_개수만큼_잘_만드는지_테스트() {
        // given, when
        List<String> numbers =  Random.getRandomNumbers();

        // then
        int size = numbers.size();
        assertThat(size).isEqualTo(Resource.SELECT_NUMBER_LENGTH);
    }
}
