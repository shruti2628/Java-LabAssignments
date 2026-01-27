package priorityQueueWithCustomComparatorForProducts;

import java.util.PriorityQueue;
import java.util.Comparator;

public class ProductPriorityApp {

    public static void main(String[] args) {

        Comparator<Product> lowPriceFirst =
                Comparator.comparingDouble(Product::getProductPrice);

        PriorityQueue<Product> pq =
                new PriorityQueue<>(lowPriceFirst);

        pq.add(new Product(101, "Laptop", 60000));
        pq.add(new Product(102, "Pen", 10));
        pq.add(new Product(103, "Notebook", 25));
        pq.add(new Product(104, "Bag", 400));
        pq.add(new Product(105, "Mouse", 500));

        while (!pq.isEmpty()) {
            System.out.println("Processing product: " + pq.poll());
        }
    }
}

