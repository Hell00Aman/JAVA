import java.util.Arrays;   // Import Arrays class to create list
import java.util.List;     // Import List interface

public class ProductUsingReduce {

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // Convert the list into a stream and use reduce() to calculate product
        // 1 is the identity value for multiplication
        // The lambda expression multiplies two numbers
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        // Print the product of all elements
        System.out.println("Product of all elements: " + product);
    }
}
