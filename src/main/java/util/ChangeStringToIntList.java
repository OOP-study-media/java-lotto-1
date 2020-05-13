package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChangeStringToIntList {
    public static List<Integer> change(String numbers) {
        List<String> targetNumbers = Arrays.asList(numbers.split(","));
        List<Integer> changedNumbers = new ArrayList<>();

        for (int i = 0; i < targetNumbers.size(); i++) {
            changedNumbers.add(Integer.parseInt(targetNumbers.get(i)));
        }

        return changedNumbers;
    }
}
