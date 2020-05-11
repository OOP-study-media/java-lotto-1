package ui;

import model.Lotto;
import model.Rank;
import res.Resource;

import java.util.List;
import java.util.Map;

public class Output {
    private static final String BONUS_BALL_CORRECT_MESSAGE = ", 보너스 볼 일치";
    private static final String MANUALLY = "수동으로 ";
    private static final String AUTOMATICALLY = "자동으로 ";
    private static final String SHEET = "장, ";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다";
    private static final String HYPHEN = "-";
    private static final String DIVISION_LINE = HYPHEN.repeat(9);
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";
    private static final String WON = "원";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 ";
    private static final String IS = "입니다.";
    private static final String COUNT = "개";
    private static final String CORRECT = COUNT + " 일치";
    private static final String WINNING_STATISTICS = "당첨 통계";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoTickets(List<Lotto> lottoTickets, int manualLottoSize) {
        int randomLottoSize = lottoTickets.size() - manualLottoSize;
        String manualLottoMessage = MANUALLY + manualLottoSize + SHEET;
        String randomLottoMessage = AUTOMATICALLY + randomLottoSize;

        printMessage(manualLottoMessage + randomLottoMessage + PURCHASE_MESSAGE);

        for (Lotto lotto : lottoTickets) {
            printMessage(lotto.getNumbersToPrint());
        }
    }

    public static void printRank(Map<Rank, Integer> rankCount) {
        printMessage(WINNING_STATISTICS);
        for (Map.Entry<Rank, Integer> rankEntry : rankCount.entrySet()) {
            Rank rank = rankEntry.getKey();
            int count = rankEntry.getValue();

            printMessage(appendRankString(rank, count));
        }
    }

    private static String appendRankString(Rank rank, int count) {
        if (rank == Rank.MISS) {
            return DIVISION_LINE;
        }
        String rankString = rank.getCountOfMatch() + CORRECT;

        if (rank == Rank.SECOND) {
            rankString += BONUS_BALL_CORRECT_MESSAGE;
        }
        return rankString + OPEN_PARENTHESIS + rank.getWinningMoney() + WON + CLOSE_PARENTHESIS + HYPHEN + count + COUNT;
    }

    public static void printRate(Map<Rank, Integer> rankCount, int purchaseCount) {
        float sum = 0;

        for (Map.Entry<Rank, Integer> rankEntry : rankCount.entrySet()) {
            int winningMoney = rankEntry.getKey().getWinningMoney();
            int count = rankEntry.getValue();
            sum += (winningMoney * count);
        }
        Output.printMessage(TOTAL_PROFIT_RATE + (sum / Resource.PRICE) / purchaseCount + IS);
    }
}
