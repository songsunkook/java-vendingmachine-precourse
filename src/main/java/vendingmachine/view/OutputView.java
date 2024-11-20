package vendingmachine.view;

import vendingmachine.dto.CoinsResponse;

public class OutputView {

    public static void inputMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public static void machineCoins(CoinsResponse response) {
        System.out.println("\n자판기가 보유한 동전");
        response.getCoinsWithZero().entrySet()
            .forEach(set -> System.out.println(String.format(
                "%d원 - %d개",
                set.getKey().getAmount(),
                set.getValue()
            )));
    }

    public static void inputStocks() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
    }

    public static void inputMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
    }

    public static void leftMoney(int money) {
        System.out.println(String.format("\n투입 금액: %d원", money));
    }

    public static void inputBuyStock() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public static void payback(CoinsResponse response) {
        System.out.println("잔돈");
        response.getCoinsWithoutZero().entrySet()
            .forEach(set -> System.out.println(String.format(
                "%d원 - %d개",
                set.getKey().getAmount(),
                set.getValue()
            )));
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }
}
