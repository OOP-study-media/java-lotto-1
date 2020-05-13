package domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        Validator.isValidNumbers(lotto.getNumbers());
        Validator.isValidBonusNumber(bonus, lotto.getNumbers());
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonus == that.bonus &&
                lotto.equals(that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }
}
