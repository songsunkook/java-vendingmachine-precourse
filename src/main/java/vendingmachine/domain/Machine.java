package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Machine {

    private final Coins coins = new Coins();
    private final List<Stock> stocks = new ArrayList<>();

    public void setCoins(Coins coins) {
        this.coins.addAll(coins);
    }

    public void buy(int money) {
        coins.use(money);
    }

    public int getCoinCount() {
        return coins.getCount();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
}
