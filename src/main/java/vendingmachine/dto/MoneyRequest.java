package vendingmachine.dto;

import static vendingmachine.constant.ExceptionMessage.*;

import vendingmachine.constant.MachineConstant;

public class MoneyRequest {

    public final int money;

    private MoneyRequest(int money) {
        this.money = money;
    }

    public static MoneyRequest from(String money) {
        try {
            int formatted = Integer.parseInt(money);
            validate(formatted);
            return new MoneyRequest(formatted);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_MUST_BE_NUMBER.getMessage());
        }
    }

    private static void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
        if (money % MachineConstant.MINIMUM_COIN_AMOUNT != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT.getMessage());
        }
    }
}
