// UC18: Linear Search for Bogie ID

import java.util.Scanner;

public class UC18_LinearSearchBogie {

    // Method to perform linear search
    public static boolean linearSearch(String[] bogieIds, String key) {
        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found → stop early
            }
        }
        return false; // No match found after full traversal
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Create array of bogie IDs (unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Step 2: Take input from user
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        // Step 3: Perform Linear Search
        boolean found = linearSearch(bogieIds, searchKey);

        // Step 4: Display result
        if (found) {
            System.out.println("Bogie ID found in the train consist.");
        } else {
            System.out.println("Bogie ID NOT found.");
        }

        sc.close();
    }
}
