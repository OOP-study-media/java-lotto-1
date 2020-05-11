package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputPrice() throws Exception {
        return inputInt(INPUT_PRICE_MESSAGE);
    }

    private static int inputInt(String inputMessage) throws Exception {
        Output.printMessage(inputMessage);
        return Integer.parseInt(br.readLine());
    }

    public static int inputManualLottoCount() throws Exception {
        return inputInt(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
    }

    public static List<String> inputLastWeekNumbers() throws Exception {
        Output.printMessage(INPUT_NUMBERS_MESSAGE);
        return inputNumbers();
    }

    public static List<String> inputNumbers() throws Exception {
        List<String> numbers = new ArrayList<>();
        Collections.addAll(numbers, br.readLine().split(COMMA));
        return Collections.unmodifiableList(numbers);
    }

    public static int inputBonusBall() throws Exception {
        return inputInt(INPUT_BONUS_BALL_MESSAGE);
    }
}
