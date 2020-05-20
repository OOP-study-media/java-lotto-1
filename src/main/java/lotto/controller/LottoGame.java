package lotto.controller;

import lotto.model.*;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.LOTTO_PRICE;

public class LottoGame {

    public static void play() throws Exception {
        int countOfTotalLotto = InputView.getNumOfTotalLotto();
        int countOfManualLotto = InputView.getNumOfManualLotto(countOfTotalLotto);
        int countOfAutoLotto = countOfTotalLotto - countOfManualLotto;

        List<Lotto> lottoRepository = initLottoRepository(countOfManualLotto, countOfAutoLotto);
        OutputView.printPurchaseStatus(lottoRepository, countOfManualLotto, countOfAutoLotto);

        Lotto lastWeekLotto = LottoCreator.createLotto(InputView.getLastWeekLottoNum());
        int lastWeekBonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, lastWeekBonus);

        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);
        OutputView.printResult(lottoResult, countOfTotalLotto * LOTTO_PRICE);
    }

    private static List<Lotto> initLottoRepository(int numOfManualLotto, int numOfAutoLotto) throws Exception {
        List<Lotto> lottoRepository = new ArrayList<>();
        lottoRepository.addAll(createManualLottoBundle(numOfManualLotto));
        lottoRepository.addAll(createAutoLottoBundle(numOfAutoLotto));
        return lottoRepository;
    }

    private static List<Lotto> createManualLottoBundle(int countOfLotto) throws Exception {
        OutputView.printManualInputGuideMessage(countOfLotto);
        List<Lotto> lottoBundle = new ArrayList<>();
        while (lottoBundle.size() < countOfLotto) {
            String lottoNum = InputView.getManualLottoNum();
            List<Integer> convertedLottoNum = Utils.stringToList(lottoNum);
            addLotto(lottoBundle, convertedLottoNum);
        }
        return lottoBundle;
    }

    private static List<Lotto> createAutoLottoBundle(int countOfLotto) throws Exception {
        List<Lotto> lottoBundle = new ArrayList<>();
        while (lottoBundle.size() < countOfLotto) {
            List<Integer> lottoNum = RandomLottoNumCreator.getAutoLottoNums();
            addLotto(lottoBundle, lottoNum);
        }
        return lottoBundle;
    }

    private static void addLotto(List<Lotto> lottoBundle, List<Integer> lottoNum) throws Exception {
        try {
            Lotto lotto = LottoCreator.createLotto(lottoNum);
            lottoBundle.add(lotto);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }
}
