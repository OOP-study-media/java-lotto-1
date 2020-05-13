package exception.PurchasePrice;

public class MinimumPurchasePriceException extends RuntimeException {
    private static final String MINIMUM_PURCHASE_PRICE_ERROR_MESSAGE = "구입금액은 최소 1000원이어야 합니다.";

    public MinimumPurchasePriceException() {
        super(MINIMUM_PURCHASE_PRICE_ERROR_MESSAGE);
    }
}
