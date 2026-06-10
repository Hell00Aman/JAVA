import java.util.HashMap;
import java.util.Map;

/**
 * UC6: Map Bogie to Capacity (HashMap)
 * This class manages a train's consist by mapping unique Bogie IDs to 
 * their respective operational capacities (seats or cargo load limits).
 */
public class TrainConsistManager {

    // HashMap to store Bogie ID (Key) and its Capacity (Value)
    private final Map<String, Integer> bogeysCapacityMap;

    // Constructor to initialize the consist map
    public TrainConsistManager() {
        this.bogeysCapacityMap = new HashMap<>();
    }

    /**
     * Adds or updates a bogie's capacity in the train consist.
     * @param bogieId  Unique identifier for the bogie (e.g., "Sleeper-01", "AC-03")
     * @param capacity Seating capacity (passengers) or load limit (tons)
     */
    public void addBogie(String bogieId, int capacity) {
        if (capacity < 0) {
            System.out.println("❌ Error: Capacity cannot be negative for " + bogieId);
            return;
        }
        bogeysCapacityMap.put(bogieId, capacity);
        System.out.println("✓ Successfully mapped " + bogieId + " with a capacity of " + capacity);
    }

    /**
     * Removes a bogie from the consist map.
     * @param bogieId Unique identifier of the bogie to remove
     */
    public void removeBogie(String bogieId) {
        if (bogeysCapacityMap.containsKey(bogieId)) {
            int removedCapacity = bogeysCapacityMap.remove(bogieId);
            System.out.println("✓ Removed " + bogieId + " (Freed up capacity: " + removedCapacity + ")");
        } else {
            System.out.println("❌ Error: Bogie " + bogieId + " not found in the current consist.");
        }
    }

    /**
     * Retrieves the capacity of a specific bogie.
     * @param bogieId Unique identifier of the bogie
     * @return The capacity, or -1 if the bogie doesn't exist
     */
    public int getBogieCapacity(String bogieId) {
        return bogeysCapacityMap.getOrDefault(bogieId, -1);
    }

    /**
     * Calculates the total combined capacity of the entire train consist.
     * @return Sum of all capacities
     */
    public int calculateTotalConsistCapacity() {
        int totalCapacity = 0;
        for (int capacity : bogeysCapacityMap.values()) {
            totalCapacity += capacity;
        }
        return totalCapacity;
    }

    /**
     * Displays the full manifest of the train consist.
     */
    public void displayConsistManifest() {
        System.out.println("\n--- Current Train Consist Manifest ---");
        if (bogeysCapacityMap.isEmpty()) {
            System.out.println("The train consist is currently empty.");
            return;
        }
        
        // Iterating over the map entries to display data pairs
        for (Map.Entry<String, Integer> entry : bogeysCapacityMap.entrySet()) {
            System.out.println("▪ Bogie: " + entry.getKey() + " ➔ Capacity/Limit: " + entry.getValue());
        }
        System.out.println("--------------------------------------");
    }

    // Main method to simulate the scenario
    public static void main(String[] args) {
        TrainConsistManager manager = new TrainConsistManager();

        System.out.println("--- Initializing Train Consist Composition ---");
        // Populating passenger bogies (Value = Seat Count)
        manager.addBogie("Sleeper-S1", 72);
        manager.addBogie("AC-Chair-C1", 56);
        manager.addBogie("FirstClass-F1", 24);

        // Populating goods bogies (Value = Cargo Load Limit in Tons)
        manager.addBogie("Rectangular-G1", 60); 
        manager.addBogie("Cylindrical-T1", 45); 

        // Displaying manifest
        manager.displayConsistManifest();

        // Analytical Calculations
        System.out.println("\n--- Running Consist Analytics ---");
        int totalLoad = manager.calculateTotalConsistCapacity();
        System.out.println("Total Dynamic Load/Seat Capacity of Train: " + totalLoad);

        // Querying a specific item
        String queryId = "AC-Chair-C1";
        System.out.println("Checking " + queryId + " capacity: " + manager.getBogieCapacity(queryId));

        // Simulating modifications
        System.out.println("\n--- Modifying Consist Infrastructure ---");
        manager.removeBogie("FirstClass-F1");
        manager.displayConsistManifest();
        System.out.println("Updated Total Capacity: " + manager.calculateTotalConsistCapacity());
    }
}
