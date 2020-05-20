package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> stringToList(String s) {
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }
}
