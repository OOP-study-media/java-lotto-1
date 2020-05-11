package controller;

import model.Lotto;
import res.Resource;
import ui.Input;
import ui.Output;

import java.util.*;

public class LottoProvider {
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int RANGE = 45;

    public static List<Lotto> getManualLottoTickets(int count) throws Exception {
        Output.printMessage(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);

        List<Lotto> lottoTickets = new ArrayList<>();
        while (count != 0) {
            lottoTickets.add(new Lotto(Input.inputNumbers()));
            count--;
        }
        return lottoTickets;
    }

    public static List<Lotto> getRandomLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (count != 0) {
            lottoTickets.add(new Lotto(getRandomNumbers()));
            count--;
        }
        return lottoTickets;
    }

    private static List<String> getRandomNumbers() {
        Random random = new Random();
        Set<String> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < Resource.SELECT_NUMBER_LENGTH) {
            String number = random.nextInt(RANGE) + 1 + "";
            randomNumbers.add(number);
        }
        return new ArrayList<>(randomNumbers);
    }
}
