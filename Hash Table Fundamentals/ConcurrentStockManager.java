import java.util.*;

// Main class for inventory management
public class FlashSaleInventoryManager {

    // HashMap to store productId -> stock count
    private HashMap<String, Integer> inventory;

    // Waiting list (FIFO) using LinkedHashMap: productId -> list of users
    private HashMap<String, Queue<Integer>> waitingList;

    // Constructor
    public FlashSaleInventoryManager() {
        inventory = new HashMap<>();
        waitingList = new HashMap<>();
    }

    // Add product with initial stock
    public void addProduct(String productId, int stock) {
        inventory.put(productId, stock);
        waitingList.put(productId, new LinkedList<>());
    }

    // Check stock availability (O(1))
    public int checkStock(String productId) {
        return inventory.getOrDefault(productId, 0);
    }

    // Purchase item (synchronized for thread safety)
    public synchronized String purchaseItem(String productId, int userId) {

        int stock = inventory.getOrDefault(productId, 0);

        // If stock available
        if (stock > 0) {
            inventory.put(productId, stock - 1);
            return "Success! Remaining stock: " + (stock - 1);
        } 
        // If stock not available → add to waiting list
        else {
            waitingList.get(productId).add(userId);
            return "Out of stock. Added to waiting list.";
        }
    }

    // Process waiting list when stock is refilled
    public synchronized void restock(String productId, int quantity) {

        int currentStock = inventory.getOrDefault(productId, 0);
        inventory.put(productId, currentStock + quantity);

        Queue<Integer> queue = waitingList.get(productId);

        // Serve waiting users in FIFO order
        while (!queue.isEmpty() && inventory.get(productId) > 0) {
            int user = queue.poll();
            inventory.put(productId, inventory.get(productId) - 1);

            System.out.println("Order confirmed for waiting user: " + user);
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();

        // Add product with 3 units (example)
        manager.addProduct("IPHONE15_256GB", 3);

        // Check stock
        System.out.println("Stock: " + manager.checkStock("IPHONE15_256GB"));

        // Simulate purchases
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 101));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 102));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 103));

        // Stock exhausted
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 104));

        // Restock and process waiting list
        manager.restock("IPHONE15_256GB", 2);
    }
}
