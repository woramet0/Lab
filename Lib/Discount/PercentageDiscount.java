package Lib.Discount;

import Lib.Product;

public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculateDiscount(Product product, int quantity) {
        double totalPrice = product.getPrice() * quantity;
        return totalPrice * (percent / 100.0);
    }
}