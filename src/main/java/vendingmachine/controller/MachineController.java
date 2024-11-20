package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private final MachineService machineService = new MachineService();

    public void run() {
        OutputView.inputMachineMoney();
        machineService.setMachineMoney(InputView.machineMoney());

        OutputView.machineCoins(machineService.getMachineCoins());

        OutputView.inputStocks();
        machineService.setMachineStocks(InputView.stocks());

        OutputView.inputMoney();
        machineService.inputMoney(InputView.money());

        while (machineService.canMoreOrder()) {
            OutputView.leftMoney(machineService.leftMoney());
            OutputView.inputBuyStock();
            machineService.buyStock(InputView.buyStock());
        }

        OutputView.leftMoney(machineService.leftMoney());
        OutputView.payback(machineService.payback());
    }
}
