// Demonstrates closure using lambda in Java
import java.util.function.Function;

public class ClosureAdder {

    // Method that returns a function (closure)
    public static Function<Integer, Integer> createAdder(int fixedValue) {

        // Lambda captures fixedValue (closure)
        return (x) -> x + fixedValue;
    }

    public static void main(String[] args) {

        // Create a function that adds 10
        Function<Integer, Integer> addTen = createAdder(10);

        // Use the returned function
        System.out.println(addTen.apply(5));  // Output: 15
        System.out.println(addTen.apply(20)); // Output: 30
    }
}
