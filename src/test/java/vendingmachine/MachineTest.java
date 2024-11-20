package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Machine;

class MachineTest {

    @Test
    void 현재_보유한_최소_개수의_동전으로_잔돈을_돌려준다() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        Machine machine = new Machine();
        machine.setCoins(coins);
        machine.buy(1110);
        assertThat(machine.getCoinCount()).isEqualTo(4);
    }
}
