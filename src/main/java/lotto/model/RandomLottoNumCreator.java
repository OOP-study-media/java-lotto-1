package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.*;

public class RandomLottoNumCreator {

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomBox = IntStream
                .rangeClosed(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomBox);
        return randomBox.subList(ZERO, LOTTO_LENGTH);
    }

    public static List<Integer> getAutoLottoNums() {
        return createRandomNumbers();
    }
}
