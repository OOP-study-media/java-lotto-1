package controller;

import model.Lotto;
import model.Rank;
import model.Validator;
import model.WinningLotto;
import res.Resource;
import ui.Input;
import ui.Output;

import java.security.InvalidParameterException;
import java.util.*;

public class LottoProgram {
    public void start() throws Exception {
        int purchaseCount = Input.inputPrice() / Resource.PRICE;
        int manualCount = Input.inputManualLottoCount();
        validateManualCount(purchaseCount, manualCount);

        List<Lotto> lottoTickets = setupLottoTickets(purchaseCount, manualCount);

        WinningLotto winningLotto = new WinningLotto(new Lotto(Input.inputLastWeekNumbers()), Input.inputBonusBall());
        TreeMap<Rank, Integer> rankCount = winningLotto.getRankCount(lottoTickets);
        printResult(rankCount, purchaseCount);
    }

    private void validateManualCount(int total, int manualCount) {
        try {
            Validator.checkManualLottoCount(total, manualCount);
        } catch (InvalidParameterException e) {
            Output.printMessage(e.getMessage());
            System.exit(Resource.EXIT_INVALID_INPUT);
        }
    }

    private List<Lotto> setupLottoTickets(int count, int manualCount) throws Exception {
        List<Lotto> lottoTickets = new ArrayList<>();
        int randomTicketCount = count - manualCount;

        lottoTickets.addAll(getManualLottoTickets(manualCount));
        lottoTickets.addAll(getRandomLottoTickets(randomTicketCount));

        Output.printLottoTickets(lottoTickets, manualCount);
        return lottoTickets;
    }

    private List<Lotto> getManualLottoTickets(int count) throws Exception {
        Output.printMessage(Resource.INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);

        List<Lotto> lottoTickets = new ArrayList<>();
        while (count != 0) {
            lottoTickets.add(new Lotto(Input.inputNumbers()));
            count--;
        }
        return lottoTickets;
    }

    private List<Lotto> getRandomLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (count != 0) {
            lottoTickets.add(new Lotto(Lotto.getRandomNumbers()));
            count--;
        }
        return lottoTickets;
    }

    private void printResult(TreeMap<Rank, Integer> rankCount, int purchaseCount) {
        Output.printRank(rankCount);
        Output.printRate(rankCount, purchaseCount);
    }
}
