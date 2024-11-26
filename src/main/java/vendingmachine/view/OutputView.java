package vendingmachine.view;

import static vendingmachine.view.OutputMessage.*;

import vendingmachine.dto.CoinsResponse;

public class OutputView {

    private StringBuilder buffer = new StringBuilder();

    public void inputMachineMoney() {
        printWithoutBuffer(INPUT_MACHINE_MONEY.getMessage());
    }

    public void machineCoins(CoinsResponse response) {
        print(MACHINE_COINS.getMessage());
        response.getCoinsWithZero().forEach((key, value) -> print(COIN_FORMAT.getMessage(key.getAmount(), value)));
        flush();
    }

    public void inputStocks() {
        printWithoutBuffer(INPUT_STOCKS.getMessage());
    }

    public void inputMoney() {
        printWithoutBuffer(INPUT_MONEY.getMessage());
    }

    public void leftMoney(int money) {
        printWithoutBuffer(LEFT_MONEY.getMessage(money));
    }

    public void inputBuyStock() {
        printWithoutBuffer(INPUT_BUY_STOCK.getMessage());
    }

    public void payback(CoinsResponse response) {
        print(PAYBACK.getMessage());
        response.getCoinsWithoutZero().forEach((key, value) -> print(COIN_FORMAT.getMessage(key.getAmount(), value)));
        flush();
    }

    public void exception(Exception e) {
        print(e.getMessage());
        print(NEW_LINE.getMessage());
        flush();
    }

    private void print(String content) {
        buffer.append(content);
    }

    private void printWithoutBuffer(String content) {
        buffer.append(content);
        flush();
    }

    private void flush() {
        System.out.print(buffer);
        buffer = new StringBuilder();
    }
}
