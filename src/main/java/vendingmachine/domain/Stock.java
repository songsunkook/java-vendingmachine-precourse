package vendingmachine.domain;

public class Stock {

    private final String name;
    private final int cost;
    private final int quantity;

    public Stock(String name, int cost, int quantity) {
        if (cost % 10 != 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }
}
