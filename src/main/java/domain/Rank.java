package domain;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치(2000000000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스볼 일치(30000000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치(150000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치(50000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치(5000원) - "), // 5등
    MISS(0, 0, "");

    private static final int MINIMUM_COUNT_FOR_WINNING = 3;
    private static final int MINIMUM_MATCH_COUNT = 0;

    private final int countOfMatch;
    private final int winningMoney;
    private final String message;

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < MINIMUM_COUNT_FOR_WINNING && countOfMatch >= MINIMUM_MATCH_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    public String getMessage(int count) {
        return message + count + "개";
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
