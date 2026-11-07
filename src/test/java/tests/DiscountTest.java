package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import logic.CheckoutDiscountCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountTest {

    @ParameterizedTest(name = "[{index}] qty={0}, value={1} -> {2}%")
    @CsvSource({
        "1, 50, 0",     // Min
        "2, 50, 0",     // Min+1
        "4, 50, 0",     // slab boundary
        "5, 50, 5",     // Nominal / slab boundary
        "9, 50, 5",     // Max-1
        "10, 50, 10",   // Max
        "5, 150, 7",    // slab plus high-value bonus
        "10, 150, 12"
    })
    void validDiscounts(int qty, double value, double expected) {
        assertThat(CheckoutDiscountCalculator.calculateDiscount(qty, value)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] qty={0} is invalid")
    @ValueSource(ints = {-1, 0, 11})   // Min-1 and Max+1
    void invalidQuantityThrows(int qty) {
        assertThatThrownBy(() -> CheckoutDiscountCalculator.calculateDiscount(qty, 50))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void zeroOrderValueThrows() {
        assertThatThrownBy(() -> CheckoutDiscountCalculator.calculateDiscount(3, 0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}