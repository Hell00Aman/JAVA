import java.util.Arrays;   // Import Arrays class to create list
import java.util.List;     // Import List interface

public class CombineDigitsUsingReduce {

    public static void main(String[] args) {

        // Create a list of digits
        List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);

        // Convert the list into a stream and use reduce() to combine digits
        // The lambda expression shifts the previous number by one digit
        // and adds the next digit
        int number = digits.stream()
                .reduce(0, (a, b) -> a * 10 + b);

        // Print the combined integer
        System.out.println("Combined number: " + number);
    }
}
