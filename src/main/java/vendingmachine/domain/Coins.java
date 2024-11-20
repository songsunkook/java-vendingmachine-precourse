package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

public class Coins {

    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

    public void add(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }

    public void add(Coin coin, int amount) {
        coins.put(coin, coins.getOrDefault(coin, 0) + amount);
    }

    public int total() {
        return coins.entrySet().stream()
            .mapToInt(set -> set.getKey().getAmount() * set.getValue())
            .sum();
    }

    public void addAll(Coins coins) {
        this.coins.putAll(coins.coins);
    }

    public int getCount() {
        return coins.entrySet().stream()
            .mapToInt(set -> set.getValue())
            .sum();
    }

    public Coins payback(int money) {
        Coins payback = new Coins();
        for (int i = 0; i < Coin.values().length; i++) {
            Coin coin = Coin.values()[i];
            Integer coinCount = coins.get(coin);
            if (coinCount == null || money < coin.getAmount()) {
                continue;
            }
            int paybackAmount = Math.min(money / coin.getAmount(), coinCount);
            money -= coin.getAmount() * paybackAmount;
            coins.put(coin, coins.get(coin) - paybackAmount);
            payback.add(coin, paybackAmount);
        }
        return payback;
    }

    public Map<Coin, Integer> get() {
        return coins;
    }
}
