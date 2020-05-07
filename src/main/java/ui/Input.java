package ui;

import res.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputPrice() throws Exception {
        return inputInt(Resource.INPUT_PRICE_MESSAGE);
    }

    private static int inputInt(String inputMessage) throws Exception {
        Output.printMessage(inputMessage);
        return Integer.parseInt(br.readLine());
    }

    public static int inputManualLottoCount() throws Exception {
        return inputInt(Resource.INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
    }

    public static List<String> inputLastWeekNumbers() throws Exception {
        Output.printMessage(Resource.INPUT_NUMBERS_MESSAGE);
        return inputNumbers();
    }

    public static List<String> inputNumbers() throws Exception {
        List<String> numbers = new ArrayList<>();
        Collections.addAll(numbers, br.readLine().split(Resource.COMMA));
        return Collections.unmodifiableList(numbers);
    }

    public static int inputBonusBall() throws Exception {
        return inputInt(Resource.INPUT_BONUS_BALL_MESSAGE);
    }
}
