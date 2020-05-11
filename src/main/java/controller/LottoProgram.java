package controller;

import model.Lotto;
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

        List<Lotto> lottoTickets = setupLottoTickets(
                LottoProvider.getManualLottoTickets(manualCount), LottoProvider.getRandomLottoTickets(purchaseCount - manualCount));

        Output.printLottoTickets(lottoTickets, manualCount);

        WinningLotto winningLotto = new WinningLotto(new Lotto(Input.inputLastWeekNumbers()), Input.inputBonusBall());
        Map<Rank, Integer> rankCount = winningLotto.getRankCount(lottoTickets);
        printResult(rankCount, purchaseCount);
    }

    private List<Lotto> setupLottoTickets(List<Lotto> manualLottoTickets, List<Lotto> randomLottoTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(manualLottoTickets);
        lottoTickets.addAll(randomLottoTickets);
        return lottoTickets;
    }

    private void printResult(Map<Rank, Integer> rankCount, int purchaseCount) {
        Output.printRank(rankCount);
        Output.printRate(rankCount, purchaseCount);
    }

}
