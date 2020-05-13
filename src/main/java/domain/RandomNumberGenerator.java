package domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MINIMUM_RANDOM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 45;
    private static final Random random = new Random();

    private RandomNumberGenerator() {
        throw new AssertionError();
    }

    public static int generateRandomNumber() {
        return random.nextInt(MAXIMUM_RANDOM_NUMBER_RANGE) + MINIMUM_RANDOM_NUMBER_RANGE;
    }
}
