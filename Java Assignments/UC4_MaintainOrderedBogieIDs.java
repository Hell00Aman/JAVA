// UC4: Maintain Ordered Bogie IDs using LinkedList
// This program demonstrates how LinkedList preserves order and allows efficient insertions/deletions

import java.util.LinkedList;

public class UC4_MaintainOrderedBogieIDs {

    public static void main(String[] args) {

        // Step 1: Create a LinkedList to represent train consist
        LinkedList<String> train = new LinkedList<>();

        // Step 2: Add bogies in sequence
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC Coach");
        train.add("Cargo");
        train.add("Guard");

        // Step 3: Insert Pantry Car at position 2 (index starts from 0)
        train.add(2, "Pantry Car");

        // Step 4: Remove first and last bogie
        train.removeFirst(); // removes Engine
        train.removeLast();  // removes Guard

        // Step 5: Display final ordered train consist
        System.out.println("Final Train Consist (Ordered):");
        for (String bogie : train) {
            System.out.println(bogie);
        }
    }
}
