// UC5: Preserve Insertion Order of Bogies using LinkedHashSet
// This program demonstrates how LinkedHashSet maintains order and removes duplicates

import java.util.LinkedHashSet;

public class UC5_PreserveInsertionOrderBogieIDs {

    public static void main(String[] args) {

        // Step 1: Create a LinkedHashSet to store bogies
        // Maintains insertion order + ensures uniqueness
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Step 2: Add bogies in sequence
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // Step 3: Attempt to add duplicate bogie
        train.add("Sleeper"); // Duplicate (will be ignored)

        // Step 4: Display final train formation
        System.out.println("Final Train Formation (Insertion Order Preserved):");
        for (String bogie : train) {
            System.out.println(bogie);
        }

        // Note:
        // Duplicate "Sleeper" is not added again
        // Order remains same as insertion
    }
}
