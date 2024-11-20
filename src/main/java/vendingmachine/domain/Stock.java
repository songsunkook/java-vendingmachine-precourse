package vendingmachine.domain;

import static vendingmachine.constant.ExceptionMessage.COST_MUST_BE_POSITIVE_NUMBER;
import static vendingmachine.constant.ExceptionMessage.COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT;
import static vendingmachine.constant.MachineConstant.MINIMUM_COIN_AMOUNT;

public class Stock {

    private final String name;
    private final int cost;
    private int quantity;

    public Stock(String name, int cost, int quantity) {
        if (cost % MINIMUM_COIN_AMOUNT != 0) {
            throw new IllegalArgumentException(COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT.getMessage());
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
