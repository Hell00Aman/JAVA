// UC19: Binary Search for Bogie ID

import java.util.Arrays;
import java.util.Scanner;

public class UC19_BinarySearchBogie {

    // Method to perform Binary Search
    public static boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds.length == 0) return false;

        // Step 1: Ensure sorted input
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        // Step 2: Binary Search logic
        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Unsorted bogie IDs (handled internally)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Step 2: Input search key
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 3: Perform Binary Search
        boolean found = binarySearch(bogieIds, key);

        // Step 4: Display result
        if (found) {
            System.out.println("Bogie ID found using Binary Search.");
        } else {
            System.out.println("Bogie ID NOT found.");
        }

        sc.close();
    }
}
