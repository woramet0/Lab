package Lib.Discount;

import Lib.Product;

public class BulkDiscount implements DiscountStrategy {
    private final int minQuantity;
    private final double discountPerItem;

    public BulkDiscount(int minQuantity, double discountPerItem) {
        this.minQuantity = minQuantity;
        this.discountPerItem = discountPerItem;
    }

    @Override
    public double calculateDiscount(Product product, int quantity) {
        if (quantity >= minQuantity) {
            return discountPerItem * quantity;
        }
        return 0.0;
    }
}