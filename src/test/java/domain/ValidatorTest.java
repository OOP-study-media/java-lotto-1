package domain;

import exception.ManualLotto.*;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import exception.WinningLotto.BetweenBonusAndWinningNumbersDuplicateExcetpion;
import exception.WinningLotto.BonusNumberRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    @Test
    void 최소구매금액_만족_테스트() {
        assertThatExceptionOfType(MinimumPurchasePriceException.class)
                .isThrownBy(() -> Validator.isCorrectPurchasePrice(900));
    }

    @Test
    void 구매금액_단위_테스트() {
        assertThatExceptionOfType(PurchasePriceUnitException.class)
                .isThrownBy(() -> Validator.isCorrectPurchasePrice(1010));
    }

    @Test
    void 수동매수_최소_테스트() {
        assertThatExceptionOfType(MinimumCountOfManualLottoException.class)
                .isThrownBy(() -> Validator.isCorrectCountOfManualLotto(5, -1));
    }

    @Test
    void 수동매수_최대_테스트() {
        assertThatExceptionOfType(MaximumCountOfManualLottoException.class)
                .isThrownBy(() -> Validator.isCorrectCountOfManualLotto(5, 6));
    }

    @Test
    void 수동로또번호_갯수_테스트() {
        assertThatExceptionOfType(CountOfSelectNumberException.class)
                .isThrownBy(() -> Validator.isValidNumbers(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void 수동로또번호_중복_테스트() {
        assertThatExceptionOfType(SelectedNumbersDuplicateException.class)
                .isThrownBy(() -> Validator.isValidNumbers(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }

    @Test
    void 수동로또번호_범위_테스트() {
        assertThatExceptionOfType(LottoNumberOutOfRangeException.class)
                .isThrownBy(() -> Validator.isValidNumbers(Arrays.asList(1, 2, 3, 4, 5, 46)));
    }

    @Test
    void 당첨번호_보너스번호_중복_테스트() {
        assertThatExceptionOfType(BetweenBonusAndWinningNumbersDuplicateExcetpion.class)
                .isThrownBy(() -> Validator.isValidBonusNumber(5, Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 보너스번호_범위_테스트() {
        assertThatExceptionOfType(BonusNumberRangeException.class)
                .isThrownBy(() -> Validator.isValidBonusNumber(46, Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}