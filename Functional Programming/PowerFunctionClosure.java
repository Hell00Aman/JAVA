// PowerFunctionClosure.java
// This program demonstrates a closure-like behavior in Java
// that generates a power function (square, cube, etc.)

import java.util.function.Function;

public class PowerFunctionClosure {

    public static void main(String[] args) {

        // Create power functions
        Function<Integer, Integer> square = createPowerFunction(2);
        Function<Integer, Integer> cube = createPowerFunction(3);

        // Use the functions
        System.out.println("Square of 4: " + square.apply(4));
        System.out.println("Cube of 3: " + cube.apply(3));
    }

    // This method returns a function that remembers the exponent
    public static Function<Integer, Integer> createPowerFunction(int exponent) {

        // Lambda captures 'exponent'
        return (base) -> {
            int result = 1;

            // Calculate power using loop
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }

            return result;
        };
    }
}
