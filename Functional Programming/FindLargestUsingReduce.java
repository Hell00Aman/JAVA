import java.util.Arrays;          // Import Arrays class to create list
import java.util.List;            // Import List interface
import java.util.Optional;        // Import Optional class for safe result handling

public class FindLargestUsingReduce {

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23, 56);

        // Convert the list into a stream and use reduce() to find the largest number
        // The lambda expression compares two numbers and returns the larger one
        Optional<Integer> largest = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);

        // Check if a value is present and print the largest number
        largest.ifPresent(num -> System.out.println("Largest number: " + num));
    }
}
