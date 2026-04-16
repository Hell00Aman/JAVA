import java.util.*;
import java.util.concurrent.*;

// Main class
public class FlashSaleInventoryManager {

    // Stock variable (shared resource)
    private static int stock = 100;

    // Queue for waiting list
    private static Queue<String> waitingList = new LinkedList<>();

    // Lock object for synchronization
    private static final Object lock = new Object();

    public static void main(String[] args) {

        // Thread pool to simulate 1000 concurrent users
        ExecutorService executor = Executors.newFixedThreadPool(50);

        // Simulate 200 purchase requests
        for (int i = 1; i <= 200; i++) {
            String user = "User" + i;

            executor.execute(() -> purchaseItem(user));
        }

        executor.shutdown();
    }

    // Purchase method (O(1) operation)
    public static void purchaseItem(String user) {

        synchronized (lock) { // Ensures thread safety

            if (stock > 0) {
                stock--; // Reduce stock
                System.out.println(user + " purchased item. Remaining stock: " + stock);
            } else {
                // Add to waiting list
                waitingList.add(user);
                System.out.println(user + " added to waiting list.");
            }
        }
    }

    // Method to check stock instantly
    public static int checkStock() {
        return stock; // O(1)
    }

    // Restock and serve waiting list
    public static void restock(int quantity) {

        synchronized (lock) {
            stock += quantity;

            // Serve waiting users
            while (stock > 0 && !waitingList.isEmpty()) {
                String user = waitingList.poll();
                stock--;
                System.out.println(user + " fulfilled from waiting list. Stock: " + stock);
            }
        }
    }
}
