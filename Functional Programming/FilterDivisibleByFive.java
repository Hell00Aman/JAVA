// Program to filter numbers divisible by 5 from a given list using Java Streams

import java.util.*;        // Import utility package for List and Arrays
import java.util.stream.*; // Import Stream package

public class FilterDivisibleByFive {

    public static void main(String[] args) {

        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(10, 12, 15, 18, 20, 23, 25, 30);

        // Using stream() to process the list
        // filter() checks each number
        // Condition: number % 5 == 0 (divisible by 5)
        List<Integer> result = numbers.stream()
                .filter(n -> n % 5 == 0) // keeps only numbers divisible by 5
                .collect(Collectors.toList()); // converts stream back to list

        // Printing the original list
        System.out.println("Original List: " + numbers);

        // Printing numbers divisible by 5
        System.out.println("Numbers divisible by 5: " + result);
    }
}
