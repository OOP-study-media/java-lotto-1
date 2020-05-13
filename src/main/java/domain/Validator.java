package domain;

import exception.ManualLotto.*;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import exception.WinningLotto.BetweenBonusAndWinningNumbersDuplicateExcetpion;
import exception.WinningLotto.BonusNumberRangeException;

import java.util.*;

public class Validator {
    private static final int MINIMUM_PURCHASE_PRICE = 1000;
    private static final int MINIMUM_MANUAL_LOTTO_COUNT = 0;
    private static final int ONE_LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private Validator() {
        throw new AssertionError();
    }

    public static void isCorrectPurchasePrice(int purchasePrice) {
        if (purchasePrice < MINIMUM_PURCHASE_PRICE) {
            throw new MinimumPurchasePriceException();
        }

        if (purchasePrice % MINIMUM_PURCHASE_PRICE != 0) {
            throw new PurchasePriceUnitException();
        }
    }

    public static void isCorrectCountOfManualLotto(int countOfPurchaseLotto, int countOfManualLotto) {
        if (countOfManualLotto < MINIMUM_MANUAL_LOTTO_COUNT) {
            throw new MinimumCountOfManualLottoException();
        }

        if (countOfPurchaseLotto < countOfManualLotto) {
            throw new MaximumCountOfManualLottoException(Integer.toString(countOfPurchaseLotto) + "장 입니다.");
        }
    }

    public static void isValidNumbers(List<Integer> selectedNumbers) {
        if (selectedNumbers.size() != ONE_LOTTO_SIZE) {
            throw new CountOfSelectNumberException();
        }

        Set<Integer> checkDuplicate = new HashSet<>(selectedNumbers);

        if (selectedNumbers.size() != checkDuplicate.size()) {
            throw new SelectedNumbersDuplicateException();
        }

        for (Integer selectedNumber : selectedNumbers) {
            if (selectedNumber < MINIMUM_LOTTO_NUMBER
                    || selectedNumber > MAXIMUM_LOTTO_NUMBER) {
                throw new LottoNumberOutOfRangeException();
            }
        }

    }

    public static void isValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BetweenBonusAndWinningNumbersDuplicateExcetpion();
        }
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new BonusNumberRangeException();
        }
    }
}
