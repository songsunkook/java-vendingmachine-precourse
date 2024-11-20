package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final MachineService machineService = new MachineService();

    public void run() {
        process(this::setupMachineMoney);
        process(this::setupMachineStocks);
        process(this::inputMoney);
        process(this::buyStocks);
        process(this::result);
    }

    private void setupMachineMoney() {
        OutputView.inputMachineMoney();
        machineService.setMachineMoney(InputView.machineMoney());
        OutputView.machineCoins(machineService.getMachineCoins());
    }

    private void setupMachineStocks() {
        OutputView.inputStocks();
        machineService.setMachineStocks(InputView.stocks());
    }

    private void inputMoney() {
        OutputView.inputMoney();
        machineService.inputMoney(InputView.money());
    }

    private void buyStocks() {
        while (machineService.canMoreOrder()) {
            buyStock();
        }
    }

    private void buyStock() {
        OutputView.leftMoney(machineService.leftMoney());
        OutputView.inputBuyStock();
        machineService.buyStock(InputView.buyStock());
    }

    private void result() {
        OutputView.leftMoney(machineService.leftMoney());
        OutputView.payback(machineService.payback());
    }

    public void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.exception(e);
            process(action);
        }
    }
}
