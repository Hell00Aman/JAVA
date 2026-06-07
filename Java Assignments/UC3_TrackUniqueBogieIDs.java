// UC3: Track Unique Bogie IDs using HashSet
// This program demonstrates how HashSet automatically removes duplicate bogie IDs

import java.util.HashSet;
import java.util.Set;

public class UC3_TrackUniqueBogieIDs {

    public static void main(String[] args) {

        // Step 1: Create a HashSet to store Bogie IDs
        // HashSet ensures all elements are unique
        Set<String> bogieIDs = new HashSet<>();

        // Step 2: Add bogie IDs (including duplicates intentionally)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // Duplicate
        bogieIDs.add("BG104");
        bogieIDs.add("BG102"); // Duplicate

        // Step 3: Display the unique bogie IDs
        System.out.println("Final Unique Bogie IDs in Train Consist:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }

        // Note:
        // Duplicate entries (BG101, BG102) are automatically ignored by HashSet
    }
}
