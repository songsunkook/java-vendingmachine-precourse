package vendingmachine.domain;

import static vendingmachine.constant.ExceptionMessage.COST_MUST_BE_POSITIVE_NUMBER;
import static vendingmachine.constant.ExceptionMessage.COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT;
import static vendingmachine.constant.MachineConstant.MINIMUM_COIN_AMOUNT;

public class Stock {

    private final String name;
    private final int cost;
    private int quantity;

    public Stock(String name, int cost, int quantity) {
        validateCost(cost);
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    private static void validateCost(int cost) {
        validatePositiveNumber(cost);
        validateCanDivide(cost);
    }

    private static void validatePositiveNumber(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException(COST_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void validateCanDivide(int cost) {
        if (cost % MINIMUM_COIN_AMOUNT != 0) {
            throw new IllegalArgumentException(COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void useQuantity(int count) {
        quantity -= count;
    }

    public boolean hasMore() {
        return quantity > 0;
    }
}
