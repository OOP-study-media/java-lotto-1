package lotto.view;

import lotto.utils.Utils;
import lotto.validators.BonusNumberValidator;
import lotto.validators.CountOfManualLottoValidator;
import lotto.validators.LottoNumberValidator;
import lotto.validators.LottoPriceValidator;

import java.util.List;
import java.util.Scanner;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.view.OutputView.printMessage;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumOfTotalLotto() {
        String totalPrice;
        printMessage("구입 금액을 입력해 주세요.");
        totalPrice = scanner.nextLine();
        try {
            LottoPriceValidator.validate(totalPrice);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getNumOfTotalLotto();
        }
        return Integer.parseInt(totalPrice) / LOTTO_PRICE;
    }

    public static int getNumOfManualLotto(int numOfTotalLotto) {
        printMessage("수동으로 구매할 로또 수를 입력해 주세요. ");
        String numOfManualLotto = scanner.nextLine();
        try {
            CountOfManualLottoValidator.validate(numOfTotalLotto, numOfManualLotto);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getNumOfManualLotto(numOfTotalLotto);
        }
        return Integer.parseInt(numOfManualLotto);
    }

    public static String getManualLottoNum() {
        return scanner.nextLine();
    }

    public static List<Integer> getLastWeekLottoNum() throws Exception {
        printMessage("지난 주 당첨 번호를 입력해 주세요. ");
        String lottoNum = getManualLottoNum();
        List<Integer> lastWeekLottoNum = Utils.stringToList(lottoNum);
        try {
            LottoNumberValidator.validate(lastWeekLottoNum);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getLastWeekLottoNum();
        }
        return lastWeekLottoNum;
    }

    public static int getLastWeekBonus(List<Integer> lastWeekAnswers) {
        int bonus;
        printMessage("보너스 볼을 입력해 주세요. ");
        try {
            bonus = scanner.nextInt();
            BonusNumberValidator.validate(lastWeekAnswers, bonus);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getLastWeekBonus(lastWeekAnswers);
        }
        return bonus;
    }
}
