package ui;

import model.Lotto;
import model.Rank;
import res.Resource;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Output {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoTickets(List<Lotto> lottoTickets, int manualLottoSize) {
        int randomLottoSize = lottoTickets.size() - manualLottoSize;
        String manualLottoMessage = Resource.MANUALLY + Resource.BLANK + manualLottoSize + Resource.SHEET + Resource.COMMA;
        String randomLottoMessage = Resource.AUTOMATICALLY + Resource.BLANK + randomLottoSize;

        printMessage(manualLottoMessage + Resource.BLANK + randomLottoMessage + Resource.PURCHASE_MESSAGE);

        for (Lotto lotto : lottoTickets) {
            lotto.printNumbers();
        }
    }

    public static void printRank(TreeMap<Rank, Integer> rankCount) {
        printMessage(Resource.WINNING_STATISTICS);
        for (Map.Entry<Rank, Integer> rankEntry : rankCount.entrySet()) {
            Rank rank = rankEntry.getKey();
            int count = rankEntry.getValue();

            printMessage(appendRankString(rank, count));
        }
    }

    private static String appendRankString(Rank rank, int count) {
        if (rank == Rank.MISS) {
            return Resource.DIVISION_LINE;
        }
        String rankString = rank.getCountOfMatch() + Resource.COUNT + Resource.BLANK + Resource.CORRECT;

        if (rank == Rank.SECOND) {
            rankString += Resource.BONUS_BALL_CORRECT_MESSAGE;
        }
        return rankString + Resource.OPEN_PARENTHESIS + rank.getWinningMoney() + Resource.WON + Resource.CLOSE_PARENTHESIS + Resource.HYPHEN + count + Resource.COUNT;
    }

    public static void printRate(TreeMap<Rank, Integer> rankCount, int purchaseCount) {
        float sum = 0;

        for (Map.Entry<Rank, Integer> rankEntry : rankCount.entrySet()) {
            int winningMoney = rankEntry.getKey().getWinningMoney();
            int count = rankEntry.getValue();
            sum += (winningMoney * count);
        }
        Output.printMessage(Resource.TOTAL_PROFIT_RATE + (sum / Resource.PRICE) / purchaseCount + Resource.IS);
    }
}
