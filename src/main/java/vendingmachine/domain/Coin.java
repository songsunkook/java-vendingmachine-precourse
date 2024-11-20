package vendingmachine.domain;

import static vendingmachine.constant.ExceptionMessage.INVALID_COIN_TYPE_REQUEST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getAmounts() {
        return Arrays.stream(values())
            .map(Coin::getAmount)
            .collect(Collectors.toList());
    }

    public static Coin from(int amount) {
        return Arrays.stream(values())
            .filter(coin -> coin.amount == amount)
            .findAny()
            .orElseThrow(() -> new IllegalStateException(INVALID_COIN_TYPE_REQUEST.getMessage()));
    }

    public int getAmount() {
        return amount;
    }
}
