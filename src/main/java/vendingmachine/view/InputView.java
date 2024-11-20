package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.StocksRequest;

public class InputView {

    public static int machineMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력");
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
