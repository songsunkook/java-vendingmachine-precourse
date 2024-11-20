package vendingmachine.domain;

public class Money {

    private static final int DEFAULT_AMOUNT = 0;

    private final int money;

    public Money() {
        this(DEFAULT_AMOUNT);
    }

    public Money(int money) {
        this.money = money;
    }

    public Money add(int money) {
        return new Money(this.money + money);
    }

    public Money use(int money) {
        return new Money(this.money - money);
    }

    public int get() {
        return money;
    }
}
