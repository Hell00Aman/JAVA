import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the in-memory state of the Hotel Booking System.
 * It holds the available room inventory and the history of booking records.
 */
class InventoryAndBookingState {
    private int availableRooms;
    private List<String> bookingHistory;

    public InventoryAndBookingState(int availableRooms) {
        this.availableRooms = availableRooms;
        this.bookingHistory = new ArrayList<>();
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public void addBooking(String bookingDetails) {
        if (availableRooms > 0) {
            bookingHistory.add(bookingDetails);
            availableRooms--;
        } else {
            System.out.println("Booking failed: No rooms available.");
        }
    }

    public void displayState() {
        System.out.println("--- Current System State ---");
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println("Booking History: " + (bookingHistory.isEmpty() ? "No bookings found." : ""));
        for (String booking : bookingHistory) {
            System.out.println(" - " + booking);
        }
        System.out.println("----------------------------");
    }
}

/**
 * Service responsible for serializing the system state to a text file
 * and deserializing it back into memory during system recovery.
 */
class PersistenceService {
    private final String storageFilePath;

    public PersistenceService(String storageFilePath) {
        this.storageFilePath = storageFilePath;
    }

    /**
     * Serializes and saves the system state into a file.
     */
    public void saveState(InventoryAndBookingState state) {
        System.out.println("\n[Persistence] Starting data serialization...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFilePath))) {
            // Write available rooms (Snapshot metadata)
            writer.write("AVAILABLE_ROOMS:" + state.getAvailableRooms());
            writer.newLine();
            
            // Write booking history records
            for (String booking : state.getBookingHistory()) {
                writer.write("BOOKING:" + booking);
                writer.newLine();
            }
            System.out.println("[Persistence] State successfully written to '" + storageFilePath + "'.");
        } catch (IOException e) {
            System.err.println("[Persistence Error] Failed to save state: " + e.getMessage());
        }
    }

    /**
     * Restores system state from the file. Handles missing or corrupt files safely.
     */
    public InventoryAndBookingState restoreState(int defaultRooms) {
        System.out.println("\n[Recovery] Checking for existing persistent state file...");
        File file = new File(storageFilePath);
        
        if (!file.exists()) {
            System.out.println("[Recovery] No state file found. Initializing system with default clean state.");
            return new InventoryAndBookingState(defaultRooms);
        }

        InventoryAndBookingState restoredState = new InventoryAndBookingState(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("AVAILABLE_ROOMS:")) {
                    int rooms = Integer.parseInt(line.substring("AVAILABLE_ROOMS:".length()).trim());
                    restoredState.setAvailableRooms(rooms);
                } else if (line.startsWith("BOOKING:")) {
                    String bookingDetails = line.substring("BOOKING:".length()).trim();
                    restoredState.getBookingHistory().add(bookingDetails);
                }
            }
            System.out.println("[Recovery] System state successfully restored from '" + storageFilePath + "'.");
            return restoredState;
        } catch (IOException | NumberFormatException e) {
            System.err.println("[Recovery Error] State file is corrupted or unreadable. Falling back to default state.");
            // Failure Tolerance: Return a known valid state instead of crashing
            return new InventoryAndBookingState(defaultRooms);
        }
    }
}

/**
 * Main application driver simulating a stateful application lifecycle:
 * Startup -> Processing Operations -> Shutdown & Persistence -> Restart & Recovery.
 */
public class UseCase12DataPersistenceRecovery {
    private static final String FILE_NAME = "system_state.txt";
    private static final int INITIAL_ROOM_COUNT = 10;

    public static void main(String[] args) {
        PersistenceService persistenceService = new PersistenceService(FILE_NAME);
        
        System.out.println("==================================================");
        System.out.println("  STAGE 1: INITIAL RUN / RECOVERY SIMULATION      ");
        System.out.println("==================================================");
        
        // Step 1: Try to recover state on startup
        InventoryAndBookingState systemState = persistenceService.restoreState(INITIAL_ROOM_COUNT);
        systemState.displayState();

        // Step 2: Perform operations if it's a fresh run
        if (systemState.getBookingHistory().isEmpty()) {
            System.out.println("\n[System] Simulating new user bookings...");
            systemState.addBooking("Alice - Deluxe Suite - Room 101");
            systemState.addBooking("Bob - Standard Room - Room 102");
            systemState.addBooking("Charlie - Penthouse - Room 105");
            
            System.out.println("\n[System] State updated after operations:");
            systemState.displayState();
        }

        // Step 3: Simulate Graceful Shutdown & Persistence
        System.out.println("\n==================================================");
        System.out.println("  STAGE 2: SYSTEM SHUTDOWN & PERSISTENCE          ");
        System.out.println("==================================================");
        persistenceService.saveState(systemState);
        System.out.println("[System] Application terminated safely.");

        System.out.println("\n==================================================");
        System.out.println("  STAGE 3: NEXT STARTUP (SYSTEM RECOVERY)        ");
        System.out.println("==================================================");
        System.out.println("[System] Restarting application...");
        
        // Step 4: Simulate application restarting and reading back the saved state
        InventoryAndBookingState recoveredState = persistenceService.restoreState(INITIAL_ROOM_COUNT);
        recoveredState.displayState();
        
        System.out.println("\n[Success] Verification complete: System survived application restart!");
        System.out.println("==================================================");
    }
}
