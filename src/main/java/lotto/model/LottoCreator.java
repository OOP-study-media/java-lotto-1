package lotto.model;

import lotto.validators.LottoNumberValidator;

import java.util.List;

public class LottoCreator {
    public static Lotto createLotto(List<Integer> lottoNum) throws Exception {
        LottoNumberValidator.test(lottoNum);
        return new Lotto(lottoNum);
    }
}
