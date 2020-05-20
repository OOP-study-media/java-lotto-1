package lotto.model;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countOfMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
