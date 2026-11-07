package logic;

public class CheckoutDiscountCalculator {

    public static double calculateDiscount(int quantity, double orderValue) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        if (quantity > 10) {
            throw new IllegalArgumentException("Quantity must not exceed 10");
        }
        if (orderValue <= 0) {
            throw new IllegalArgumentException("Order value must be positive");
        }

        double discount;
        if (quantity >= 10) {
            discount = 10;
        } else if (quantity >= 5) {
            discount = 5;
        } else {
            discount = 0;
        }

        if (orderValue > 100) {
            discount += 2;
        }
        return discount;
    }
}