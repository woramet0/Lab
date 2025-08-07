package Lib;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void updateQuantity(int newQuantity) {
        if (newQuantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        this.quantity = newQuantity;
    }

    public void increaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
        this.quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
        if (this.quantity - amount < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity -= amount;
    }
}