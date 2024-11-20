package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import vendingmachine.dto.StocksRequest;

class StocksRequestTest {

    @Test
    void 가격이_숫자가_아닌_경우_예외를_반환한다() {
        assertThatThrownBy(() -> StocksRequest.from("[콜라,1500,20];[사이다,천원,10]"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_숫자가_아닌_경우_예외를_반환한다() {
        assertThatThrownBy(() -> StocksRequest.from("[콜라,1500,20];[사이다,1000,열개]"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
