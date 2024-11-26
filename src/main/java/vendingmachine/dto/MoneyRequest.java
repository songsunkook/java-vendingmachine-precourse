package vendingmachine.dto;

import static vendingmachine.constant.ExceptionMessage.*;
import static vendingmachine.constant.MachineConstant.MINIMUM_COIN_AMOUNT;

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
        validatePositiveNumber(money);
        validateCanDivide(money);
    }

    private static void validatePositiveNumber(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(COST_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void validateCanDivide(int money) {
        if (money % MINIMUM_COIN_AMOUNT != 0) {
            throw new IllegalArgumentException(COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT.getMessage());
        }
    }
}
