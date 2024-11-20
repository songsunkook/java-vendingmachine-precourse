package vendingmachine.constant;

public enum ExceptionMessage {
    // IllegalArgumentException
    COST_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT(String.format("가격이 %,d원으로 나누어떨어지지 않습니다.",
        MachineConstant.MINIMUM_COIN_AMOUNT), IllegalArgumentException.class),
    COST_MUST_BE_POSITIVE_NUMBER("가격은 양수여야 합니다.", IllegalArgumentException.class),
    MONEY_MUST_BE_POSITIVE_NUMBER("금액은 양수여야 합니다.", IllegalArgumentException.class),
    MONEY_MUST_BE_NUMBER("금액은 숫자여야 합니다.", IllegalArgumentException.class),
    MONEY_NOT_DIVIDED_IN_MINIMUM_COIN_AMOUNT(String.format("금액이 %,d원으로 나누어떨어지지 않습니다.",
        MachineConstant.MINIMUM_COIN_AMOUNT), IllegalArgumentException.class),
    NOT_FOUND_STOCK_NAME("존재하지 않는 상품명입니다.", IllegalArgumentException.class),
    STOCK_COST_AND_QUANTITY_MUST_BE_NUMBER("상품 가격과 수량은 숫자여야 합니다.", IllegalArgumentException.class),

    // IllegalStateException
    INVALID_COIN_TYPE_REQUEST("잘못된 동전 종류에 대한 요청입니다.", IllegalStateException.class),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String ILLEGAL_ARGUMENT_POSTFIX = " 다시 입력해주세요.";

    private final String message;
    private final Class<?> exceptionType;

    ExceptionMessage(String message, Class<?> exceptionType) {
        this.message = message;
        this.exceptionType = exceptionType;
    }

    public String getMessage() {
        return String.format(generateMessage());
    }

    public String getMessage(Object... args) {
        return String.format(generateMessage(), args);
    }

    private String generateMessage() {
        if (exceptionType == IllegalArgumentException.class) {
            return PREFIX + message + ILLEGAL_ARGUMENT_POSTFIX;
        }
        return PREFIX + message;
    }
}