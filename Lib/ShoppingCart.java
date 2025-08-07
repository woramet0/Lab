package Lib;

import java.util.ArrayList;
import java.util.List;
import Lib.Discount.*;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private PricingService pricingService;
    private ProductCatalog productCatalog;

    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog) {
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
    }

    public void addItem(String productId, int quantity) throws ProductNotFoundException {
        Product product = productCatalog.findById(productId);
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(String productId) throws InvalidOperationException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                return;
            }
        }
        throw new InvalidOperationException("Cannot remove item. Product ID '" + productId + "' not found in cart.");
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            DiscountStrategy strategy = pricingService.getStrategy(item.getProduct().getId());
            if (strategy != null) {
                total += strategy.getDiscountedPrice(item.getProduct(), item.getQuantity());
            } else {
                total += item.getProduct().getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }
}