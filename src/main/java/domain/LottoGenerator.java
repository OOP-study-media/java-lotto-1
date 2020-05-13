package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
        throw new AssertionError();
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        List<Integer> selectedNumbers = new ArrayList<>(numbers);

        Collections.sort(selectedNumbers);
        return new Lotto(selectedNumbers);
    }
}
