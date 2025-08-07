package Lib;

public final class Product {
    private final int productId;
    private final String name;
    private final double price;
    private final String description;

    public Product(int productId, String name, double price) {
        this(productId, name, price, "");
    }

    public Product(int productId, String name, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
}