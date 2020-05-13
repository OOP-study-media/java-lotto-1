package domain;

import util.ChangeStringToIntList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int ONE_LOTTO_SIZE = 6;

    private LottoMachine() {
        throw new AssertionError();
    }

    public static Lotto createManualLotto(String selectNumbers) {
        List<Integer> lottoNumbers = ChangeStringToIntList.change(selectNumbers);

        return LottoGenerator.generateLotto(lottoNumbers);
    }

    public static void completeAllLotto(LottoRepository lottoRepository, int countOfAutomaticLotto) {
        IntStream.range(0, countOfAutomaticLotto).forEach(i -> lottoRepository.addLotto(createAutomaticLotto()));
    }

    public static WinningLotto createWinningLotto(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private static Lotto createAutomaticLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() != ONE_LOTTO_SIZE) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return LottoGenerator.generateLotto(lottoNumbers);
    }
}