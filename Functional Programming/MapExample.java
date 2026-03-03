// Import required package
import java.util.*;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        // -------------------------------
        // PART 1: Convert strings to uppercase
        // -------------------------------

        // Create a list of strings
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        // Use Stream map() method to convert each string to uppercase
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase) // Convert each name to uppercase
                                       .collect(Collectors.toList()); // Collect result into a new list

        // Print uppercase list
        System.out.println("Uppercase Names:");
        System.out.println(upperNames);


        // -------------------------------
        // PART 2: Calculate cube of numbers
        // -------------------------------

        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use Stream map() method to calculate cube of each number
        List<Integer> cubes = numbers.stream()
                                     .map(n -> n * n * n) // Cube of each number
                                     .collect(Collectors.toList()); // Collect into list

        // Print cube list
        System.out.println("\nCubes of Numbers:");
        System.out.println(cubes);
    }
}
