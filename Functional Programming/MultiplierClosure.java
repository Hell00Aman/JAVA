// Demonstrates closure to create multiplier functions
import java.util.function.Function;

public class MultiplierClosure {

    // Method that returns a multiplier function (closure)
    public static Function<Integer, Integer> createMultiplier(int factor) {

        // Lambda captures 'factor' (closure)
        return (x) -> x * factor;
    }

    public static void main(String[] args) {

        // Create multiplier functions
        Function<Integer, Integer> doubleFunc = createMultiplier(2);
        Function<Integer, Integer> tripleFunc = createMultiplier(3);

        // Use the functions
        System.out.println(doubleFunc.apply(5));  // Output: 10
        System.out.println(tripleFunc.apply(5));  // Output: 15
    }
}
