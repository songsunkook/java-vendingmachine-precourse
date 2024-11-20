package vendingmachine.dto;

import static vendingmachine.constant.ExceptionMessage.MONEY_MUST_BE_NUMBER;

public class MoneyRequest {

    public final int money;

    private MoneyRequest(int money) {
        this.money = money;
    }

    public static MoneyRequest from(String money) {
        try {
            return new MoneyRequest(Integer.parseInt(money));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_MUST_BE_NUMBER.getMessage());
        }
    }
}
