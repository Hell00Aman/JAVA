import java.util.*;

/**
 * Book My Stay - Hotel Booking Management System
 * Use Case 6: Room Allocation & Reservation Confirmation
 * 
 * Concepts: Queue (FIFO), HashMap, Set (Uniqueness), Inventory Sync
 * Focus: Prevent double booking and ensure consistency
 * 
 * @author Aman
 * @version 6.0
 */

// Reservation class (booking request)
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory Service (state holder)
class InventoryService {
    private Map<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    // Check availability
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    // Update inventory after allocation
    public void reduceRoom(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Booking Service (allocation logic)
class BookingService {

    private Queue<Reservation> queue;
    private InventoryService inventory;

    // Track allocated room IDs (no duplicates)
    private Set<String> allocatedRoomIds;

    // Map room type -> allocated IDs
    private Map<String, Set<String>> roomAllocations;

    public BookingService(Queue<Reservation> queue, InventoryService inventory) {
        this.queue = queue;
        this.inventory = inventory;
        this.allocatedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }

    // Generate unique room ID
    private String generateRoomId(String type) {
        return type.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Process booking requests
    public void processBookings() {

        System.out.println("\n--- Processing Bookings ---");

        while (!queue.isEmpty()) {

            Reservation req = queue.poll(); // FIFO

            String type = req.roomType;

            System.out.println("\nProcessing request for " + req.guestName);

            // Check availability
            if (inventory.getAvailability(type) > 0) {

                String roomId;

                // Ensure unique ID
                do {
                    roomId = generateRoomId(type);
                } while (allocatedRoomIds.contains(roomId));

                // Add to allocated set
                allocatedRoomIds.add(roomId);

                // Map room type to IDs
                roomAllocations.putIfAbsent(type, new HashSet<>());
                roomAllocations.get(type).add(roomId);

                // Update inventory
                inventory.reduceRoom(type);

                // Confirm booking
                System.out.println("Booking Confirmed!");
                System.out.println("Guest: " + req.guestName);
                System.out.println("Room Type: " + type);
                System.out.println("Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed - No rooms available for " + type);
            }
        }
    }
}

// Main class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v6.0 =====");

        // Create booking queue
        Queue<Reservation> queue = new LinkedList<>();
        queue.offer(new Reservation("Aman", "Single Room"));
        queue.offer(new Reservation("Riya", "Suite Room"));
        queue.offer(new Reservation("John", "Single Room"));
        queue.offer(new Reservation("David", "Single Room")); // may fail

        // Initialize inventory
        InventoryService inventory = new InventoryService();

        // Initialize booking service
        BookingService bookingService = new BookingService(queue, inventory);

        // Process bookings
        bookingService.processBookings();

        System.out.println("\nApplication Ended.");
    }
}
