import java.util.*;

// Transaction class
class Transaction {
    String accountId;
    int amount;

    Transaction(String accountId, int amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public String toString() {
        return accountId + " | Amount: " + amount;
    }
}

public class AccountIDLookup {

    static int comparisons = 0;

    // ============ LINEAR SEARCH (First & Last Occurrence) ============
    public static void linearSearch(Transaction[] arr, String target) {

        int first = -1, last = -1;
        comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].accountId.equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // ============ BINARY SEARCH (Find any occurrence) ============
    public static int binarySearch(Transaction[] arr, String target) {

        int low = 0, high = arr.length - 1;
        comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].accountId.compareTo(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // Count total occurrences using binary search
    public static int countOccurrences(Transaction[] arr, String target) {

        int index = binarySearch(arr, target);
        if (index == -1) return 0;

        int count = 1;

        // Left side
        int i = index - 1;
        while (i >= 0 && arr[i].accountId.equals(target)) {
            count++;
            i--;
        }

        // Right side
        i = index + 1;
        while (i < arr.length && arr[i].accountId.equals(target)) {
            count++;
            i++;
        }

        return count;
    }

    public static void main(String[] args) {

        Transaction[] logs = {
            new Transaction("A101", 500),
            new Transaction("A102", 200),
            new Transaction("A101", 800),
            new Transaction("A103", 300),
            new Transaction("A101", 100)
        };

        String target = "A101";

        // Linear Search
        linearSearch(logs, target);

        // Sort logs by accountId for binary search
        Arrays.sort(logs, Comparator.comparing(t -> t.accountId));

        System.out.println("\nAfter Sorting:");
        for (Transaction t : logs) System.out.println(t);

        // Binary Search
        int index = binarySearch(logs, target);
        System.out.println("\nBinary Search Index: " + index);
        System.out.println("Comparisons: " + comparisons);

        // Count occurrences
        int count = countOccurrences(logs, target);
        System.out.println("Total Occurrences: " + count);
    }
}
