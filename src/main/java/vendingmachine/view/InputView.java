package vendingmachine.view;

import static vendingmachine.constant.ExceptionMessage.MONEY_MUST_BE_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.StocksRequest;

public class InputView {

    public static int machineMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_MUST_BE_NUMBER.getMessage());
        }
    }

    public static StocksRequest stocks() {
        return StocksRequest.from(Console.readLine());
    }

    public static int money() {
        return Integer.parseInt(Console.readLine());
    }

    public static String buyStock() {
        return Console.readLine();
    }
}
