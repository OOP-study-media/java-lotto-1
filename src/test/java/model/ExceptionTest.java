package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import res.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    void 로또_번호_6개_아닐_때_테스트() {
        assertThatThrownBy(() -> Exception.checkLottoNumbersCount(numbers))
                .isInstanceOf(Exception.InvalidLottoNumbersCountException.class)
                .hasMessageContaining(Resource.INVALID_NUMBERS_COUNT_MESSAGE);
    }

    @Test
    void 로또_번호_6개_일때_테스트() {
        numbers.add(6);

        assertThatCode(() -> Exception.checkLottoNumbersCount(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    void 수동_입력_개수_구입개수보다_많을_때_테스트() {
        int total = 3;
        int manualCount = 4;

        assertThatThrownBy(() -> Exception.checkManualLottoCount(total, manualCount))
                .isInstanceOf(Exception.InvalidManualLottoCountException.class)
                .hasMessageContaining(Resource.INVALID_MANUAL_COUNT_MESSAGE);
    }

    @Test
    void 수동_입력_개수_구입개수보다_적을_때_테스트() {
        int total = 4;
        int manualCount = 3;

        assertThatCode(() -> Exception.checkManualLottoCount(total, manualCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 문자_입력했을때_테스트() {
        String input = "문자";

        assertThatThrownBy(() -> Exception.checkNumber(input))
                .isInstanceOf(Exception.InvalidNumberException.class)
                .hasMessageContaining(Resource.INVALID_NUMBER_MESSAGE);
    }

    @Test
    void 숫자_입력했을때_테스트() {
        String input = "1";

        assertThatCode(() -> Exception.checkNumber(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자_중복있을_때_테스트() {
        numbers.add(1);

        assertThatThrownBy(() -> Exception.checkDuplicate(numbers))
                .isInstanceOf(Exception.InvalidNumberSetException.class)
                .hasMessageContaining(Resource.DUPLICATE_MESSAGE);
    }

    @Test
    void 숫자_중복없을_때_테스트() {
        numbers.add(6);

        assertThatCode(() -> Exception.checkDuplicate(numbers))
                .doesNotThrowAnyException();
    }


}
