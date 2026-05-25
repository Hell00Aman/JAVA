import java.util.*;

/**
 * Book My Stay - Hotel Booking Management System
 * Use Case 4: Room Search & Availability Check
 * 
 * Demonstrates read-only access to inventory without modifying system state.
 * Focus: Separation of concerns, defensive programming, filtering logic
 * 
 * @author Aman
 * @version 4.0
 */

// Room domain model (holds details)
class Room {
    String type;
    double price;
    String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    // Display room details
    public void display() {
        System.out.println(type + " | Price: $" + price + " | Amenities: " + amenities);
    }
}

// Inventory class (state holder - read-only in this use case)
class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        // Initial availability
        inventory.put("Single Room", 3);
        inventory.put("Double Room", 0); // Not available
        inventory.put("Suite Room", 2);
    }

    // Read-only method
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Return all room types
    public Set<String> getRoomTypes() {
        return inventory.keySet();
    }
}

// Search service (separation of concerns)
class SearchService {

    private RoomInventory inventory;
    private Map<String, Room> roomData;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;

        // Room details (domain model)
        roomData = new HashMap<>();
        roomData.put("Single Room", new Room("Single Room", 100, "WiFi, TV"));
        roomData.put("Double Room", new Room("Double Room", 180, "WiFi, TV, AC"));
        roomData.put("Suite Room", new Room("Suite Room", 300, "WiFi, TV, AC, Mini Bar"));
    }

    // Read-only search method
    public void searchAvailableRooms() {

        System.out.println("\n--- Available Rooms ---");

        for (String type : inventory.getRoomTypes()) {

            int available = inventory.getAvailability(type);

            // Defensive check: show only available rooms
            if (available > 0) {
                Room room = roomData.get(type);

                if (room != null) { // Safety check
                    room.display();
                    System.out.println("Available: " + available + "\n");
                }
            }
        }
    }
}

// Main class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v4.0 =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize search service
        SearchService searchService = new SearchService(inventory);

        // Guest performs search (read-only)
        System.out.println("\nGuest searching for rooms...");
        searchService.searchAvailableRooms();

        System.out.println("\n(No inventory was modified during search)");
        System.out.println("\nApplication Ended.");
    }
}
