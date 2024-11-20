package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.StocksRequest;

public class InputView {

    public static int machineMoney() {
        return Integer.parseInt(Console.readLine());
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
