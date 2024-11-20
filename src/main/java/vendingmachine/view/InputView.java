package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.BuyStockRequest;
import vendingmachine.dto.MoneyRequest;
import vendingmachine.dto.StocksRequest;

public class InputView {

    private InputView() {
    }

    public static MoneyRequest machineMoney() {
        return MoneyRequest.from(Console.readLine());
    }

    public static StocksRequest stocks() {
        return StocksRequest.from(Console.readLine());
    }

    public static MoneyRequest money() {
        return MoneyRequest.from(Console.readLine());
    }

    public static BuyStockRequest buyStock() {
        return BuyStockRequest.from(Console.readLine());
    }
}
