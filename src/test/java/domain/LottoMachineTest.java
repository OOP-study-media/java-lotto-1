package domain;

import org.junit.jupiter.api.Test;
import util.ChangeStringToIntList;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 자동로또_반환_테스트() {
        String numbers = "1,2,3,4,5,6";
        List<Integer> compareNumber = ChangeStringToIntList.change(numbers);

        Lotto lotto = LottoMachine.createManualLotto(numbers);

        assertThat(lotto.getNumbers().containsAll(compareNumber)).isTrue();
    }

    @Test
    void 자동로또_생성을_통한_전체로또완성_테스트(){
        LottoRepository lottoRepository = new LottoRepository();

        LottoMachine.completeAllLotto(lottoRepository,5);

        assertThat(lottoRepository.getAllLotto().size()).isEqualTo(5);
    }

    public static WinningLotto createWinningLotto(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningLotto(winningNumberLotto, bonusNumber);
    }
    @Test
    void 당첨로또_반환_테스트(){
        String winningNumbers = "1,2,3,4,5,6";
        Lotto winningNumberLotto = new Lotto(ChangeStringToIntList.change(winningNumbers));
        int bonus = 7;

        WinningLotto winningLotto = LottoMachine.createWinningLotto(winningNumberLotto,bonus);

        assertThat(winningLotto.compareLotto(ChangeStringToIntList.change(winningNumbers),bonus)).isTrue();
    }

}