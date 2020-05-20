package lotto.validators;

import lotto.exceptions.IncorrectLottoLengthException;
import lotto.exceptions.IncorrectLottoRangeException;

import java.util.List;

import static lotto.model.Lotto.*;

public class LottoNumberValidator {
    public static void test(List<Integer> lottoNum) throws Exception {
        if (lottoNum.size() != LOTTO_LENGTH) {
            throw new IncorrectLottoLengthException();
        }

        for (Integer integer : lottoNum) {
            if (integer < LOTTO_MIN_VALUE || integer > LOTTO_MAX_VALUE) {
                throw new IncorrectLottoRangeException();
            }
        }
    }
}
