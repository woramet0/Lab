
public class PricingService {
    private final DiscountStrategy discountStrategy;

    public PricingService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(Product product, int quantity) {
        double totalPrice = product.getPrice() * quantity;
        double discount = discountStrategy.calculateDiscount(product, quantity);
        double finalPrice = totalPrice - discount;
        return Math.max(finalPrice, 0.0);
    }
}