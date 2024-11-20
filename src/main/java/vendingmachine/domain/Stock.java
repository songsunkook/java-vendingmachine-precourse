package vendingmachine.domain;

import static vendingmachine.constant.ExceptionMessage.COST_MUST_BE_POSITIVE_NUMBER;
import static vendingmachine.constant.ExceptionMessage.NOT_DIVIDED_COST;

public class Stock {

    private final String name;
    private final int cost;
    private int quantity;

    public Stock(String name, int cost, int quantity) {
        if (cost % 10 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_COST.getMessage(10));
        }
        if (cost < 0) {
            throw new IllegalArgumentException(COST_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void useQuantity(int count) {
        quantity -= count;
    }
}
