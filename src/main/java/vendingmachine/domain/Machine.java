package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Machine {

    private final Coins coins = new Coins();
    private final List<Stock> stocks = new ArrayList<>();
    private int inputtedMoney = 0;

    public void setCoins(Coins coins) {
        this.coins.addAll(coins);
    }

    public void inputMoney(int money) {
        inputtedMoney += money;
    }

    public void buy(int money) {
        coins.use(money);
    }

    public void buy(String name) {
        buy(name, 1);
    }

    public void buy(String name, int count) {
        Stock target = findStockByName(name);
        if (inputtedMoney < target.getCost() * count) {
            throw new IllegalArgumentException("넣은 금액보다 비싼 요청");
        }
        if (target.getQuantity() < count) {
            throw new IllegalArgumentException("재고보다 많은 개수 요청");
        }
        target.useQuantity(count);
        inputtedMoney -= target.getCost() * count;
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

    private Stock findStockByName(String name) {
        return stocks.stream()
            .filter(stock -> stock.getName() == name)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품"));
    }

    public boolean canMoreOrder() {
        return stocks.stream()
            .anyMatch(stock -> stock.getCost() <= inputtedMoney) &&
            stocks.stream()
                .anyMatch(stock -> stock.getQuantity() > 0);
    }

    public Coins payback() {
        return coins.payback(inputtedMoney);
    }

    public Coins getCoins() {
        return coins;
    }

    public int getLeftMoney() {
        return inputtedMoney;
    }
}
