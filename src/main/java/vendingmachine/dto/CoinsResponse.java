package vendingmachine.dto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import vendingmachine.Coin;
import vendingmachine.domain.Coins;

public class CoinsResponse {

    private Map<Coin, Integer> coins;

    private CoinsResponse(Map<Coin, Integer> coins) {
        this.coins = new EnumMap<>(coins);
    }

    public static CoinsResponse from(Coins coins) {
        return new CoinsResponse(coins.get());
    }

    public Map<Coin, Integer> getCoinsWithZero() {
        Map<Coin, Integer> result = new EnumMap<>(coins);
        Arrays.stream(Coin.values())
            .forEach(coin -> result.put(coin, result.getOrDefault(coin, 0)));
        return result;
    }

    public Map<Coin, Integer> getCoinsWithoutZero() {
        return coins;
    }
}
