import java.util.*;

public class RiskThresholdLookup {

    static int comparisons = 0;

    // ============ LINEAR SEARCH (Unsorted) ============
    public static int linearSearch(int[] arr, int target) {
        comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i] == target) return i;
        }

        return -1;
    }

    // ============ BINARY SEARCH INSERTION POINT ============
    public static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low; // insertion index (lower_bound)
    }

    // ============ FLOOR (largest ≤ target) ============
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // ============ CEILING (smallest ≥ target) ============
    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Unsorted risk bands
        int[] unsorted = {50, 20, 80, 30, 60};
        int target = 55;

        // Linear Search
        int index = linearSearch(unsorted, target);
        System.out.println("Linear Search Index: " + index);
        System.out.println("Comparisons: " + comparisons);

        // Sorted risk bands
        int[] sorted = {20, 30, 50, 60, 80};

        // Insertion Point (lower_bound)
        int pos = findInsertionPoint(sorted, target);
        System.out.println("\nInsertion Position: " + pos);

        // Floor & Ceiling
        int floorVal = floor(sorted, target);
        int ceilVal = ceil(sorted, target);

        System.out.println("Floor (<= target): " + floorVal);
        System.out.println("Ceiling (>= target): " + ceilVal);
    }
}
