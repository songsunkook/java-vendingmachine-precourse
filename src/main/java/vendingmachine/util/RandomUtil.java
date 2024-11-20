package vendingmachine.util;

import static vendingmachine.constant.ExceptionMessage.MONEY_MUST_BE_POSITIVE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class RandomUtil {

    public static Coins moneyToCoins(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
        Coins coins = new Coins();
        while (money > 0) {
            int random = Randoms.pickNumberInList(Coin.getAmounts());
            if (random > money) {
                continue;
            }
            money -= random;
            coins.add(Coin.from(random));
        }
        return coins;
    }
}
