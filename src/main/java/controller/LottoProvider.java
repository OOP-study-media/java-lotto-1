package controller;

import model.LottoTickets;
import ui.Input;
import ui.Output;

public class LottoProvider {
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static void addManualLottoTickets(int count, LottoTickets lottoTickets) throws Exception {
        Output.printMessage(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);

        while (count != 0) {
            lottoTickets.addManual(Input.inputNumbers());
            count--;
        }
    }

    public static void addRandomLottoTickets(int count, LottoTickets lottoTickets) {
        while (count != 0) {
            lottoTickets.addRandom();
            count--;
        }
    }
}
