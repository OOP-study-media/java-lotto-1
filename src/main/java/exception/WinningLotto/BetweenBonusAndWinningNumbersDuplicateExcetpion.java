package exception.WinningLotto;

public class BetweenBonusAndWinningNumbersDuplicateExcetpion extends RuntimeException {
    private static final String BONUS_AND_WINNINGNUMBERS_DUPLICATE_ERROR_MESSAGE = "보너스번호는 당첨번호와 중복되면 안됩니다.";

    public BetweenBonusAndWinningNumbersDuplicateExcetpion() {
        super(BONUS_AND_WINNINGNUMBERS_DUPLICATE_ERROR_MESSAGE);
    }
}
