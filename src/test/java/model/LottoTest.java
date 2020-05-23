package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        // given
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add("1");
        inputNumbers.add("2");
        inputNumbers.add("3");
        inputNumbers.add("4");
        inputNumbers.add("5");
        inputNumbers.add("6");
        lotto = new Lotto(inputNumbers);
    }

    @Test
    void 문자_배열_숫자로_잘_바뀌는지_테스트() {
        // when
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).hasSize(6)
                .contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void numbers_문자로_잘_출력하는지_테스트() {
        // when
        String numbers = lotto.getNumbersToPrint();

        // then
        assertThat(numbers).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void numbers_에_포함되는지_테스트() {
        // when
        boolean contains = lotto.containsNumber(1);

        // then
        assertThat(contains).isTrue();
    }

    @Test
    void numbers_에_포함_안되는지_테스트() {
        // when
        boolean contains = lotto.containsNumber(7);

        // then
        assertThat(contains).isFalse();
    }
}
