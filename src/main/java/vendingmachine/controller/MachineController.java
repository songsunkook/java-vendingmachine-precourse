package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final OutputView outputView = new OutputView();
    private final MachineService machineService = new MachineService();

    public void run() {
        process(this::setupMachineMoney);
        process(this::setupMachineStocks);
        process(this::inputMoney);
        process(this::buyStocks);
        process(this::result);
    }

    private void setupMachineMoney() {
        outputView.inputMachineMoney();
        machineService.setMachineMoney(InputView.machineMoney());
        outputView.machineCoins(machineService.getMachineCoins());
    }

    private void setupMachineStocks() {
        outputView.inputStocks();
        machineService.setMachineStocks(InputView.stocks());
    }

    private void inputMoney() {
        outputView.inputMoney();
        machineService.inputMoney(InputView.money());
    }

    private void buyStocks() {
        while (machineService.canMoreOrder()) {
            buyStock();
        }
    }

    private void buyStock() {
        outputView.leftMoney(machineService.leftMoney());
        outputView.inputBuyStock();
        machineService.buyStock(InputView.buyStock());
    }

    private void result() {
        outputView.leftMoney(machineService.leftMoney());
        outputView.payback(machineService.payback());
    }

    public void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.exception(e);
            process(action);
        }
    }
}
