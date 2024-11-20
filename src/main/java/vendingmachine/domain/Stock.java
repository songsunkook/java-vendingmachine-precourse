package vendingmachine.domain;

public class Stock {

    private final String name;
    private final int cost;
    private int quantity;

    public Stock(String name, int cost, int quantity) {
        if (cost % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10으로 나누어떨어지지 않음");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 양수여야 함");
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
