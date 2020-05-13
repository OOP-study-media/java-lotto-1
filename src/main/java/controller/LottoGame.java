package controller;

import domain.*;

import view.InputView;
import view.OutputView;

import static view.OutputView.printErrorMessage;

public class LottoGame {
    public void run() {
        final int countOfPurchaseLotto = InputView.inputPurchasePrice();
        final int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        final int countOfAutomaticLotto = countOfPurchaseLotto - countOfManualLotto;
        LottoRepository lottoRepository = new LottoRepository();

        inputManualLotto(lottoRepository, countOfManualLotto);
        LottoMachine.completeAllLotto(lottoRepository, countOfAutomaticLotto);

        OutputView.printAllLotto(lottoRepository, countOfManualLotto, countOfAutomaticLotto);

        Lotto winningNumberLotto = inputWinningNumber();
        WinningLotto winningLotto = inputBonusNumber(winningNumberLotto);

        GameResult gameResult = new GameResult(lottoRepository, countOfPurchaseLotto, winningLotto);
        OutputView.printResult(gameResult);
    }

    private void inputManualLotto(LottoRepository lottoRepository, int countOfManualLotto) {
        int countOfFinishedLotto = 0;

        do {
            try {
                String numbers = InputView.inputManualNumber(countOfFinishedLotto);

                lottoRepository.addLotto(LottoMachine.createManualLotto(numbers));
                countOfFinishedLotto++;
            } catch (Exception e) {
                printErrorMessage(e.getMessage());
            }
        } while (!lottoRepository.isCheckLottoCount(countOfManualLotto));
    }

    private Lotto inputWinningNumber() {
        try {
            String numbers = InputView.inputWinningLottoNumbers();

            return LottoMachine.createManualLotto(numbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputWinningNumber();
        }
    }

    private WinningLotto inputBonusNumber(Lotto winnningNumberLotto) {
        try {
            int bonus = InputView.inputBonus();
            return LottoMachine.createWinningLotto(winnningNumberLotto, bonus);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputBonusNumber(winnningNumberLotto);
        }
    }
}
