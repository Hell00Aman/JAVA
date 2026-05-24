import java.util.HashMap;
import java.util.Map;

/**
 * Book My Stay - Hotel Booking Management System
 * Use Case 3: Centralized Room Inventory Management
 * 
 * Demonstrates use of HashMap for centralized inventory handling.
 * 
 * @author Aman
 * @version 3.1
 */

// Inventory class to manage room availability
class RoomInventory {

    // HashMap to store room type and available count
    private Map<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initial room availability
        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability of a specific room
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability (booking/cancellation)
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + change);
    }

    // Method to display full inventory
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v3.1 =====");

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Simulate booking (reduce availability)
        System.out.println("\nBooking 2 Single Rooms...");
        inventory.updateAvailability("Single Room", -2);

        // Simulate cancellation (increase availability)
        System.out.println("Cancelling 1 Double Room...");
        inventory.updateAvailability("Double Room", +1);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication Ended.");
    }
}
