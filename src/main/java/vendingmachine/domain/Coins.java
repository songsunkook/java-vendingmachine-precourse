package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

import vendingmachine.Coin;

public class Coins {

    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

    public void add(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }

    public int total() {
        return coins.entrySet().stream()
            .mapToInt(set -> set.getKey().getAmount() * set.getValue())
            .sum();
    }

    public void addAll(Coins coins) {
        this.coins.putAll(coins.coins);
    }

    public void use(int money) {
        for (int i = 0; i < Coin.values().length; i++) {
            Coin coin = Coin.values()[i];
            Integer coinCount = coins.get(coin);
            if (coinCount == null || money < coin.getAmount()) {
                continue;
            }
            int useAmount = Math.min(money / coin.getAmount(), coinCount);
            money -= coin.getAmount() * useAmount;
            coins.put(coin, coins.get(coin) - useAmount);
        }
        if (money != 0) {
            // 잔돈을 반환할 수 없는 경우 -> 반환 가능한 금액만 반환한다.
        }
    }

    public int getCount() {
        return coins.entrySet().stream()
            .mapToInt(set -> set.getValue())
            .sum();
    }
}