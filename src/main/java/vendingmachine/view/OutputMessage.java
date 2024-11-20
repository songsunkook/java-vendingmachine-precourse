package vendingmachine.view;

public enum OutputMessage {
    INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요.%n"),
    MACHINE_COINS("%n자판기가 보유한 동전%n"),
    COIN_FORMAT("%,d원 - %,d개%n"),
    INPUT_STOCKS("%n상품명과 가격, 수량을 입력해 주세요.%n"),
    INPUT_MONEY("%n투입 금액을 입력해 주세요.%n"),
    LEFT_MONEY("%n투입 금액: %d원%n"),
    INPUT_BUY_STOCK("구매할 상품명을 입력해 주세요.%n"),
    PAYBACK("잔돈%n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message);
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
