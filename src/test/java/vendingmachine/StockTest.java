package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Stock;

class StockTest {

    @Test
    void 상품_가격이_10원으로_나누어떨어지지_않으면_예외를_반환한다() {
        assertThatThrownBy(() -> new Stock("사이다", 1555, 10))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
