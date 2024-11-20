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
}
