import model.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import res.Resource;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
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
        assertThatThrownBy(() -> { Validator.checkLottoNumbersCount(numbers); })
                .isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining(Resource.INVALID_NUMBERS_COUNT_MESSAGE);
    }

    @Test
    void 로또_번호_6개_일때_테스트() {
        numbers.add(6);

        assertThatCode(() -> {
            Validator.checkLottoNumbersCount(numbers);
        }).doesNotThrowAnyException();
    }

    @Test
    void 수동_입력_개수_구입개수보다_많을_때_테스트() {
        int total = 3;
        int manualCount = 4;

        assertThatThrownBy(() -> { Validator.checkManualLottoCount(total, manualCount); })
                .isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining(Resource.INVALID_MANUAL_COUNT_MESSAGE);
    }

    @Test
    void 수동_입력_개수_구입개수보다_적을_때_테스트() {
        int total = 4;
        int manualCount = 3;

        assertThatCode(() -> {
            Validator.checkManualLottoCount(total, manualCount);
        }).doesNotThrowAnyException();
    }

    @Test
    void 문자_입력했을때_테스트() {
        String input = "문자";

        assertThatThrownBy(() -> { Validator.checkNumber(input); })
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(Resource.INVALID_NUMBER_MESSAGE);
    }

    @Test
    void 숫자_입력했을때_테스트() {
        String input = "1";

        assertThatCode(() -> {
            Validator.checkNumber(input);
        }).doesNotThrowAnyException();
    }

    @Test
    void 숫자_중복있을_때_테스트() {
        numbers.add(1);

        assertThatThrownBy(() -> { Validator.checkDuplicate(numbers); })
                .isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining(Resource.DUPLICATE_MESSAGE);
    }

    @Test
    void 숫자_중복없을_때_테스트() {
        numbers.add(6);

        assertThatCode(() -> {
            Validator.checkDuplicate(numbers);
        }).doesNotThrowAnyException();
    }


}
