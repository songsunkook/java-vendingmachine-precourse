package vendingmachine.dto;

import static vendingmachine.constant.ExceptionMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StocksRequest {

    private static final String DELIMITER = ";";

    public final List<InnerStock> stocks;

    private StocksRequest(List<InnerStock> stocks) {
        this.stocks = stocks;
    }

    public static StocksRequest from(String content) {
        String[] split = content.split(DELIMITER);
        return new StocksRequest(Arrays.stream(split)
            .map(InnerStock::from)
            .collect(Collectors.toList())
        );
    }

    public static class InnerStock {

        private static final String INNER_DELIMITER = ",";
        private static final String PREFIX = "[";
        private static final String POSTFIX = "]";

        public final String name;
        public final int cost;
        public final int quantity;

        public InnerStock(String name, int cost, int quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;
        }

        public static InnerStock from(String content) {
            try {
                String[] split = removePrefixPostfix(content).split(INNER_DELIMITER);
                return new InnerStock(
                    split[0],
                    parseCost(split[1]),
                    parseQuantity(split[2])
                );
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException(INVALID_REQUEST_FORMAT.getMessage());
            }
        }

        private static String removePrefixPostfix(String content) {
            return content
                .replace(PREFIX, "")
                .replace(POSTFIX, "");
        }

        private static int parseCost(String content) {
            try {
                return Integer.parseInt(content);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(COST_MUST_BE_NUMBER.getMessage());
            }
        }

        private static int parseQuantity(String content) {
            try {
                return Integer.parseInt(content);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(QUANTITY_MUST_BE_NUMBER.getMessage());
            }
        }
    }
}
