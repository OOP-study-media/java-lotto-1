package controller;

import model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoProviderTest {

    @Test
    void 랜덤_로또_개수만큼_잘_만드는지_테스트() {
        int count = 3;

        List<Lotto> lottoTickets = LottoProvider.getRandomLottoTickets(count);

        assertThat(lottoTickets.size()).isEqualTo(count);
    }
}
