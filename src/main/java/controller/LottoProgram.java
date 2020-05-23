package controller;

import model.Lotto;
import model.LottoTickets;
import model.Rank;
import model.WinningLotto;
import res.Resource;
import ui.Input;
import ui.Output;

import java.util.*;

public class LottoProgram {
    public void start() throws Exception {
        int purchaseCount = Input.inputPrice() / Resource.PRICE;
        int manualCount = Input.inputManualLottoCount();
        Validator.validateManualCount(purchaseCount, manualCount);

        List<Lotto> lottoTickets = setupLottoTickets(purchaseCount, manualCount).getLottoTickets();
        Output.printLottoTickets(lottoTickets, manualCount);

        WinningLotto winningLotto = new WinningLotto(new Lotto(Input.inputLastWeekNumbers()), Input.inputBonusBall());
        Map<Rank, Integer> rankCount = winningLotto.getRankCount(lottoTickets);
        printResult(rankCount, purchaseCount);
    }

    private static LottoTickets setupLottoTickets(int purchaseCount, int manualCount) throws Exception {
        LottoTickets lottoTickets = new LottoTickets();

        LottoProvider.addManualLottoTickets(manualCount, lottoTickets);
        LottoProvider.addRandomLottoTickets(purchaseCount - manualCount, lottoTickets);

        return lottoTickets;
    }

    private void printResult(Map<Rank, Integer> rankCount, int purchaseCount) {
        Output.printRank(rankCount);
        Output.printRate(rankCount, purchaseCount);
    }

}
