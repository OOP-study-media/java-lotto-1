package lotto.model;

import lotto.validators.LottoNumberValidator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_MAX_VALUE = 45;
    public static final int LOTTO_MIN_VALUE = 1;
    private static final int ONE = 1;
    public static final int ZERO = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int countOfMatch(Lotto lotto) {
        int countMatch = ZERO;
        for (Integer number : numbers) {
            if(checkAnotherLottoContain(lotto, number)){
                countMatch++;
            }
        }
        return countMatch;
    }

    private boolean checkAnotherLottoContain(Lotto lotto, int number) {
        return lotto.containNumber(number);
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers.stream(), lotto.numbers.stream());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
