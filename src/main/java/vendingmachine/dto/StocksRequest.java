package vendingmachine.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StocksRequest {

    public final List<InnerStock> stocks;

    private StocksRequest(List<InnerStock> stocks) {
        this.stocks = stocks;
    }

    public static StocksRequest from(String content) {
        try {
            String[] split = content.split(";");
            return new StocksRequest(Arrays.stream(split)
                .map(InnerStock::from)
                .collect(Collectors.toList())
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력");
        }
    }

    public static class InnerStock {
        public String name;
        public int cost;
        public int quantity;

        public InnerStock(String name, int cost, int quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;
        }

        public static InnerStock from(String content) {
            String[] split = content
                .replace("[", "")
                .replace("]", "")
                .split(",");

            return new InnerStock(
                split[0],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2])
            );
        }
    }
}
