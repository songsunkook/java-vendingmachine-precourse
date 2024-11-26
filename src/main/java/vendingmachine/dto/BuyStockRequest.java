package vendingmachine.dto;

public class BuyStockRequest {

    public final String name;

    private BuyStockRequest(String name) {
        this.name = name;
    }

    public static BuyStockRequest from(String name) {
        return new BuyStockRequest(name);
    }
}
