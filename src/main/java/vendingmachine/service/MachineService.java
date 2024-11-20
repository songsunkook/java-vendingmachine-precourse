package vendingmachine.service;

import java.util.stream.Collectors;

import vendingmachine.domain.Machine;
import vendingmachine.domain.Stock;
import vendingmachine.dto.BuyStockRequest;
import vendingmachine.dto.CoinsResponse;
import vendingmachine.dto.MoneyRequest;
import vendingmachine.dto.StocksRequest;
import vendingmachine.util.RandomUtil;

public class MachineService {

    private final Machine machine = new Machine();

    public void setMachineMoney(MoneyRequest request) {
        machine.setCoins(RandomUtil.generateCoins(request.money));
    }

    public CoinsResponse getMachineCoins() {
        return CoinsResponse.from(machine.getCoins());
    }

    public void setMachineStocks(StocksRequest request) {
        machine.addStocks(
            request.stocks.stream()
            .map(innerStock -> new Stock(innerStock.name, innerStock.cost, innerStock.quantity))
            .collect(Collectors.toList())
        );
    }

    public void inputMoney(MoneyRequest request) {
        machine.inputMoney(request.money);
    }

    public boolean canMoreOrder() {
        return machine.canMoreOrder();
    }

    public int leftMoney() {
        return machine.getLeftMoney();
    }

    public void buyStock(BuyStockRequest request) {
        machine.buy(request.name);
    }

    public CoinsResponse payback() {
        return CoinsResponse.from(machine.payback());
    }
}
