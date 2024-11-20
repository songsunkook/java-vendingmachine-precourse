package vendingmachine.service;

import java.util.stream.Collectors;

import vendingmachine.domain.Machine;
import vendingmachine.domain.Stock;
import vendingmachine.dto.CoinsResponse;
import vendingmachine.dto.StocksRequest;
import vendingmachine.util.RandomUtil;

public class MachineService {

    private final Machine machine = new Machine();

    public void setMachineMoney(int money) {
        machine.setCoins(RandomUtil.moneyToCoins(money));
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

    public void inputMoney(int money) {
        machine.inputMoney(money);
    }

    public boolean canMoreOrder() {
        return machine.canMoreOrder();
    }

    public int leftMoney() {
        return machine.getLeftMoney();
    }

    public void buyStock(String name) {
        machine.buy(name);
    }

    public CoinsResponse payback() {
        return CoinsResponse.from(machine.payback());
    }
}
