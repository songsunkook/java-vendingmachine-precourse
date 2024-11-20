package vendingmachine.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coins;

class RandomUtilTest {

    @Test
    void 자판기_보유_금액으로_동전을_무작위로_생성한다() {
        Coins coins = RandomUtil.moneyToCoins(5000);
        assertThat(coins.total()).isEqualTo(5000);
    }
}
