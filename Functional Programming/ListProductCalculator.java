// Import required packages
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductUsingReduce {

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // Use reduce() with lambda to calculate product
        Optional<Integer> product = numbers.stream()
                .reduce((a, b) -> a * b); // Lambda multiplies elements

        // Print result
        if (product.isPresent()) {
            System.out.println("Product: " + product.get());
        } else {
            System.out.println("List is empty");
        }
    }
}
