package lotto.validators;

import lotto.exceptions.AlreadyInLastLottoException;
import lotto.exceptions.IncorrectLottoRangeException;

import java.util.List;

import static lotto.model.Lotto.LOTTO_MAX_VALUE;
import static lotto.model.Lotto.LOTTO_MIN_VALUE;

public class BonusNumberValidator {
    public static void validate(List<Integer> lastWeekLottoNum, int bonus) throws Exception {
        if (lastWeekLottoNum.contains(bonus)) {
            throw new AlreadyInLastLottoException();
        }

        if (bonus < LOTTO_MIN_VALUE || bonus > LOTTO_MAX_VALUE) {
            throw new IncorrectLottoRangeException();
        }
    }
}
