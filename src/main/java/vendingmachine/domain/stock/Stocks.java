package vendingmachine.domain.stock;

import static vendingmachine.constant.ExceptionMessage.INVALID_STOCKS_REQUEST;
import static vendingmachine.constant.ExceptionMessage.NOT_FOUND_STOCK_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stocks {

    private final List<Stock> stocks = new ArrayList<>();

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public void addAll(List<Stock> stocks) {
        this.stocks.addAll(stocks);
    }

    public Stock findByName(String name) {
        return stocks.stream()
            .filter(stock -> Objects.equals(stock.getName(), name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_STOCK_NAME.getMessage()));
    }

    public boolean hasMore() {
        return stocks.stream().anyMatch(Stock::hasMore);
    }

    public int mostExpensiveCost() {
        return stocks.stream()
            .mapToInt(Stock::getCost)
            .max()
            .orElseThrow(() -> new IllegalStateException(INVALID_STOCKS_REQUEST.getMessage()));
    }
}
