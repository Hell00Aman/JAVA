// UC16: Bubble Sort for Passenger Bogie Capacities

import java.util.*;

public class UC16_BubbleSortPassengerBogies {

    // Bubble Sort Method
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            // Optimization: check if swap happened
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {

                    // Swap logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Step 1: Input array
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(capacities));

        // Step 2: Apply Bubble Sort
        bubbleSort(capacities);

        // Step 3: Output sorted array
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(capacities));
    }
}
