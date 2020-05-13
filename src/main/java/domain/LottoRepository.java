package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> allLotto = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        allLotto.add(lotto);
    }

    public boolean isCheckLottoCount(int countOfLotto) {
        return allLotto.size() == countOfLotto;
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(allLotto);
    }
}
