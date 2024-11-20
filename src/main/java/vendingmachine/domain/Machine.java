package vendingmachine.domain;

import java.util.List;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.stock.Stock;
import vendingmachine.domain.stock.Stocks;

public class Machine {

    private static final int BUY_QUANTITY_UNIT = 1;

    private final Coins coins = new Coins();
    private final Stocks stocks = new Stocks();
    private Money money = new Money();

    public void setCoins(Coins coins) {
        this.coins.addAll(coins);
    }

    public void inputMoney(int money) {
        this.money = this.money.add(money);
    }

    public void buy(String name) {
        Stock target = stocks.findByName(name);
        target.useQuantity(BUY_QUANTITY_UNIT);
        money = money.use(target.getCost());
    }

    public int getCoinCount() {
        return coins.getCount();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void addStocks(List<Stock> stocks) {
        this.stocks.addAll(stocks);
    }

    public boolean canMoreOrder() {
        return enoughMoney() && stocks.hasMore();
    }

    private boolean enoughMoney() {
        return stocks.mostExpensiveCost()  <= money.get();
    }

    public Coins payback() {
        return coins.payback(money.get());
    }

    public Coins getCoins() {
        return coins;
    }

    public int getLeftMoney() {
        return money.get();
    }
}
