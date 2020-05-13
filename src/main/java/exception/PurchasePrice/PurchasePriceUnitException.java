package exception.PurchasePrice;

public class PurchasePriceUnitException extends RuntimeException {
    private static final String PURCHASE_PRICE_UNIT_ERROR_MESSAGE = "구입금액은 1000원 단위여야합니다.";

    public PurchasePriceUnitException() {
        super(PURCHASE_PRICE_UNIT_ERROR_MESSAGE);
    }
}
