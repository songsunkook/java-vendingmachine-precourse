package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.Map;

public class Coins {
    
    private static final int DEFAULT_COIN_COUNT = 0;
    private static final int ADD_COIN_UNIT = 1;

    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

    public void add(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, DEFAULT_COIN_COUNT) + ADD_COIN_UNIT);
    }

    public void add(Coin coin, int amount) {
        coins.put(coin, coins.getOrDefault(coin, DEFAULT_COIN_COUNT) + amount);
    }

    public int total() {
        return coins.entrySet().stream()
            .mapToInt(this::getCoinTotalAmount)
            .sum();
    }

    private int getCoinTotalAmount(Map.Entry<Coin, Integer> coin) {
        return coin.getKey().getAmount() * coin.getValue();
    }

    public void addAll(Coins coins) {
        this.coins.putAll(coins.coins);
    }

    public int getCount() {
        return coins.values().stream()
            .mapToInt(i -> i)
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
