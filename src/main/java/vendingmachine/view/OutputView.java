package vendingmachine.view;

import static vendingmachine.view.OutputMessage.*;

import vendingmachine.dto.CoinsResponse;

public class OutputView {

    public static void inputMachineMoney() {
        print(INPUT_MACHINE_MONEY.getMessage());
    }

    public static void machineCoins(CoinsResponse response) {
        print(MACHINE_COINS.getMessage());
        response.getCoinsWithZero().forEach((key, value) -> print(COIN_FORMAT.getMessage(key.getAmount(), value)));
    }

    public static void inputStocks() {
        print(INPUT_STOCKS.getMessage());
    }

    public static void inputMoney() {
        print(INPUT_MONEY.getMessage());
    }

    public static void leftMoney(int money) {
        print(LEFT_MONEY.getMessage(money));
    }

    public static void inputBuyStock() {
        print(INPUT_BUY_STOCK.getMessage());
    }

    public static void payback(CoinsResponse response) {
        print(PAYBACK.getMessage());
        response.getCoinsWithoutZero().forEach((key, value) -> print(COIN_FORMAT.getMessage(key.getAmount(), value)));
    }

    public static void exception(Exception e) {
        print(e.getMessage());
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
