// UC6: Map Bogie to Capacity using HashMap
// This program demonstrates mapping each bogie to its seating/load capacity

import java.util.HashMap;
import java.util.Map;

public class UC6_MapBogieToCapacity {

    public static void main(String[] args) {

        // Step 1: Create a HashMap to store bogie and capacity
        // Key = Bogie Name, Value = Capacity
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Step 2: Add bogie-capacity mappings
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 100); // load capacity

        // Step 3: Display bogie and their capacities using entrySet()
        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Note:
        // Each bogie is mapped to its capacity
        // Fast lookup possible using bogie name
    }
}
