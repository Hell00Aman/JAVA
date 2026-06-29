// UC20: Exception Handling During Search Operations

import java.util.Scanner;

public class UC20_ExceptionHandlingSearch {

    // Method with validation + linear search
    public static boolean searchBogie(String[] bogieIds, String key) {

        // Step 1: Fail-fast validation
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // Step 2: Perform search (Linear Search)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // Found
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Change this array to test different scenarios
        String[] bogieIds = {}; // Empty array to trigger exception

        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        try {
            boolean found = searchBogie(bogieIds, key);

            if (found) {
                System.out.println("Bogie ID found.");
            } else {
                System.out.println("Bogie ID NOT found.");
            }

        } catch (IllegalStateException e) {
            // Step 3: Handle exception gracefully
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
