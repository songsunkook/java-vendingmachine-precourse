package vendingmachine.domain;

public class Machine {

    private final Coins coins = new Coins();

    public void setCoins(Coins coins) {
        this.coins.addAll(coins);
    }

    public void buy(int money) {
        coins.use(money);
    }

    public int getCoinCount() {
        return coins.getCount();
    }
}
