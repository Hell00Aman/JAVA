// FileName: RecursiveMaxInList.java

import java.util.Arrays;   // Import Arrays class to create list
import java.util.List;     // Import List interface

public class RecursiveMaxInList {

    // Recursive function to find the maximum element in the list
    public static int findMax(List<Integer> list, int index) {

        // Base case: if it is the last element, return it
        if (index == list.size() - 1) {
            return list.get(index);
        }

        // Recursively find the maximum from the remaining list
        int maxRest = findMax(list, index + 1);

        // Compare current element with max of remaining elements
        return Math.max(list.get(index), maxRest);
    }

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23, 56);

        // Call recursive function starting from index 0
        int max = findMax(numbers, 0);

        // Print the maximum element
        System.out.println("Maximum element in the list: " + max);
    }
}
