// E-commerce Product Search: Array vs HashMap Performance
import java.util.*;

public class PerformanceBenchmark {

    // Product class to store product details
    static class Product {
        String sku;   // Unique product ID
        String name;  // Product name
        double price; // Product price

        // Constructor to initialize product
        Product(String sku, String name, double price) {
            this.sku = sku;
            this.name = name;
            this.price = price;
        }
    }

    // Method to benchmark Array (Linear Search)
    public static void benchmarkArraySearch(Product[] products, String[] searchSKUs) {
        long startTime = System.nanoTime(); // Start time

        for (String sku : searchSKUs) {
            // Linear search: O(n)
            for (Product p : products) {
                if (p.sku.equals(sku)) {
                    break; // Stop when found
                }
            }
        }

        long endTime = System.nanoTime(); // End time
        double timeMs = (endTime - startTime) / 1000000.0;
        System.out.println("Array Search: " + timeMs + "ms");
    }

    // Method to benchmark HashMap search
    public static void benchmarkHashMapSearch(HashMap<String, Product> productMap,
                                              String[] searchSKUs) {

        long startTime = System.nanoTime();

        for (String sku : searchSKUs) {
            // Direct lookup: O(1)
            productMap.get(sku);
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1000000.0;
        System.out.println("HashMap Search: " + timeMs + "ms");
    }

    public static void main(String[] args) {

        int productCount = 100000; // Total products
        int searchCount = 10000;   // Number of searches

        // Create array and HashMap
        Product[] products = new Product[productCount];
        HashMap<String, Product> productMap = new HashMap<>();

        System.out.println("Creating " + productCount + " products...");

        // Populate data
        for (int i = 0; i < productCount; i++) {
            String sku = "SKU-" + String.format("%06d", i);
            Product p = new Product(sku, "Product " + i, 9.99 + i);

            products[i] = p;       // Store in array
            productMap.put(sku, p); // Store in HashMap
        }

        // Generate random SKUs for searching
        Random rand = new Random(42);
        String[] searchSKUs = new String[searchCount];

        for (int i = 0; i < searchCount; i++) {
            int randomIndex = rand.nextInt(productCount);
            searchSKUs[i] = "SKU-" + String.format("%06d", randomIndex);
        }

        System.out.println("\nPerforming " + searchCount + " searches...\n");

        // Run benchmarks
        benchmarkArraySearch(products, searchSKUs);
        benchmarkHashMapSearch(productMap, searchSKUs);

        // Collision Analysis
        System.out.println("\n=== Collision Analysis ===");

        Set<Integer> hashCodes = new HashSet<>();
        int collisions = 0;

        for (Product p : products) {
            int hash = p.sku.hashCode();

            if (hashCodes.contains(hash)) {
                collisions++; // Count collisions
            }

            hashCodes.add(hash);
        }

        // Print collision results
        System.out.println("Total products: " + productCount);
        System.out.println("Unique hash codes: " + hashCodes.size());
        System.out.println("Collisions: " + collisions);
        System.out.println("Collision rate: " + (collisions * 100.0 / productCount) + "%");
    }
}
