package view;

import domain.Validator;

import java.util.Scanner;

import static view.OutputView.printErrorMessage;
import static view.OutputView.printMessage;

public class InputView {
    private static final String DEMAND_PURCHASE_PRICE = "구입금액을 입력해주세요.";
    private static final String DEMAND_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String DEMAND_MANUAL_NUMBERS = "수동으로 구매하실 번호를 입력해주세요. 현재 완성된 수동 로또 개수는 : ";
    private static final String DEMAND_WINNING_NUMBERS = "지난 주 당첨번호를 입력해주세요.";
    private static final String DEMAND_BONUS_NUMBER = "보너스 볼을 입력해주세요";
    private static final int PRICE_PER_ONE_LOTTO = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int inputPurchasePrice() {
        int purchasePrice;

        try {
            printMessage(DEMAND_PURCHASE_PRICE);
            purchasePrice = scanner.nextInt();
            Validator.isCorrectPurchasePrice(purchasePrice);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputPurchasePrice();
        }
        return purchasePrice / PRICE_PER_ONE_LOTTO;
    }

    public static int inputCountOfManualLotto(int countOfPurchaseLotto) {
        int countOfManualLotto;

        try {
            printMessage(DEMAND_COUNT_OF_MANUAL_LOTTO);
            countOfManualLotto = scanner.nextInt();
            Validator.isCorrectCountOfManualLotto(countOfPurchaseLotto, countOfManualLotto);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputCountOfManualLotto(countOfPurchaseLotto);
        }

        return countOfManualLotto;
    }

    public static String inputManualNumber(int countOfFinishedLotto) {
        printMessage(DEMAND_MANUAL_NUMBERS + countOfFinishedLotto);
        return scanner.next();
    }

    public static String inputWinningLottoNumbers() {
        printMessage(DEMAND_WINNING_NUMBERS);
        return scanner.next();
    }

    public static int inputBonus() {
        printMessage(DEMAND_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
