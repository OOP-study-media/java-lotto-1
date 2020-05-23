package model;

import res.Resource;

import java.util.*;

public class Random {
    private static final int RANGE = 45;

    public static List<String> getRandomNumbers() {
        java.util.Random random = new java.util.Random();
        Set<String> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < Resource.SELECT_NUMBER_LENGTH) {
            String number = random.nextInt(RANGE) + 1 + "";
            randomNumbers.add(number);
        }
        return List.copyOf(randomNumbers);
    }
}
