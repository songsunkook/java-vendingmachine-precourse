package vendingmachine.dto;

import java.util.Map;

import vendingmachine.Coin;
import vendingmachine.domain.Coins;

public class CoinsResponse {

    public Map<Coin, Integer> coins;

    private CoinsResponse(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static CoinsResponse from(Coins coins) {
        return new CoinsResponse(coins.get());
    }
}
