package vendingmachine.domain;

import static vendingmachine.constant.ExceptionMessage.NOT_FOUND_STOCK_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void buy(String name) {
        Stock target = findStockByName(name);
        target.useQuantity(1);
        inputtedMoney -= target.getCost();
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
            .filter(stock -> Objects.equals(stock.getName(), name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_STOCK_NAME.getMessage()));
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
