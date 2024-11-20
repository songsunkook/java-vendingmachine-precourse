package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MachineTest {

    @Test
    void 현재_보유한_최소_개수의_동전으로_잔돈을_돌려준다() {
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        Machine machine = new Machine();
        machine.setCoins(coins);
        machine.inputMoney(760);
        assertThat(machine.payback().getCount()).isEqualTo(5);
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

    @Test
    void 잔돈을_모두_반환할_수_없는_경우_가능한_금액만_반환한다() {
        Machine machine = new Machine();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        machine.setCoins(coins);
        machine.inputMoney(180);
        assertThat(machine.payback().total()).isEqualTo(170);
    }

    @Test
    void 반환되지_않은_금액은_자판기에_남는다() {
        Machine machine = new Machine();
        Coins coins = new Coins();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        coins.add(Coin.COIN_10);
        machine.setCoins(coins);
        machine.inputMoney(180);
        machine.payback();
        assertThat(machine.getCoinCount()).isEqualTo(1);
    }
}
