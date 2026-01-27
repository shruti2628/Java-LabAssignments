package priorityQueueWithCustomComparatorForProducts;

public class Product {

    private int productId;
    private String productName;
    private double productPrice;

    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return productName + " (" + productPrice + ") ₹";
    }
}
