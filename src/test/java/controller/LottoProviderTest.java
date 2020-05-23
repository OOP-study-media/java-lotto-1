package controller;

import model.LottoTickets;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoProviderTest {
    private static final int COUNT = 3;

    @Test
    void 랜덤_로또_개수만큼_잘_만드는지_테스트() {
        // given
        LottoTickets lottoTickets = new LottoTickets();

        // when
        LottoProvider.addRandomLottoTickets(COUNT, lottoTickets);

        // then
        int size = lottoTickets.getLottoTickets().size();
        assertThat(size).isEqualTo(COUNT);
    }
}
