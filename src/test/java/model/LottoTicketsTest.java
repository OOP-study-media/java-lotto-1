package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    void 로또_직접_추가_테스트() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");

        // when
        lottoTickets.addManual(numbers);

        // then
        Lotto lotto = lottoTickets.getLottoTickets().get(0);
        List<Integer> saveNumbers = lotto.getNumbers();

        assertThat(saveNumbers).contains(1, 2, 3, 4, 5, 6);
    }
}
