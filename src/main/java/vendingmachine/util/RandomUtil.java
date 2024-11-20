package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class RandomUtil {

    public static Coins generateCoins(int money) {
        Coins coins = new Coins();
        while (finishGenerate(money)) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getAmounts());
            if (randomCoinAmount <= money) {
                money -= randomCoinAmount;
                coins.add(Coin.from(randomCoinAmount));
            }
        }
        return coins;
    }

    private static boolean finishGenerate(int money) {
        return money > 0;
    }
}
