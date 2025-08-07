package Lib;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product findById(String productId) throws ProductNotFoundException {
        if (!products.containsKey(productId)) {
            throw new ProductNotFoundException("Product with ID '" + productId + "' not found in catalog.");
        }
        return products.get(productId);
    }
}