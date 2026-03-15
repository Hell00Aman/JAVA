// FileName: RecursiveListSum.java

import java.util.Arrays;   // Import Arrays class to create list
import java.util.List;     // Import List interface

public class RecursiveListSum {

    // Recursive function to find the sum of list elements
    public static int sumList(List<Integer> list, int index) {

        // Base case: if index reaches list size, stop recursion
        if (index == list.size()) {
            return 0;
        }

        // Return current element + sum of remaining elements
        return list.get(index) + sumList(list, index + 1);
    }

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Call recursive function starting from index 0
        int sum = sumList(numbers, 0);

        // Print the sum of elements
        System.out.println("Sum of list elements: " + sum);
    }
}
