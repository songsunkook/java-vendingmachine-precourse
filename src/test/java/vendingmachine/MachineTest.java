package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Stock;

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

    @Test
    void 상품명_가격_수량으로_상품을_추가할_수_있다() {
        Machine machine = new Machine();
        machine.addStock(new Stock("사이다", 560, 10));
    }

    @Test
    void 사용자가_투입한_금액으로_상품을_구매할_수_있다() {
        Machine machine = new Machine();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        machine.setCoins(coins);
        machine.addStock(new Stock("사이다", 560, 10));
        machine.inputMoney(3000);
        machine.buy("사이다", 2);
    }

    @Test
    void 남은_금액이_상품_최저_가격보다_작은_경우_바로_잔돈을_돌려준다() {
        Machine machine = new Machine();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        machine.setCoins(coins);
        machine.addStock(new Stock("사이다", 1000000, 10));
        machine.inputMoney(3000);
        assertThat(machine.canMoreOrder()).isFalse();
    }

    @Test
    void 모든_상품이_소진된_경우_바로_잔돈을_돌려준다() {
        Machine machine = new Machine();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        machine.setCoins(coins);
        machine.addStock(new Stock("사이다", 1000, 0));
        machine.inputMoney(3000);
        assertThat(machine.canMoreOrder()).isFalse();
    }
}
