package Lib.Discount;

import Lib.Product;

public interface DiscountStrategy {
    double calculateDiscount(Product product, int quantity);
}