package lotto.model;

import java.util.List;

public class LottoResult {
    private final RankCount rankCount;
    private int prize;

    public LottoResult(List<Lotto> lottoRepository, WinningLotto winningLotto) {
        rankCount = new RankCount(lottoRepository, winningLotto);
        prize = calculatePrize();
    }

    private int calculatePrize() {
        return rankCount.getResult().entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public RankCount getRankCount() {
        return rankCount;
    }

    public int getPrize() {
        return prize;
    }
}
