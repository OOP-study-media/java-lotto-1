package model;

import java.util.*;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public void addManual(List<String> numbers) {
        lottoTickets.add(new Lotto(numbers));
    }

    public void addRandom() {
        lottoTickets.add(new Lotto(Random.getRandomNumbers()));
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
