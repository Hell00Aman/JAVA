// This program demonstrates a higher-order function in Java.
// A method returns a multiplier function (double, triple, etc.)
// using the Function interface and lambda expressions.

import java.util.function.Function;

public class MultiplierFunction {

    // Higher-order function that returns a multiplier function
    public static Function<Integer, Integer> createMultiplier(int factor) {
        return number -> number * factor;
    }

    public static void main(String[] args) {

        // Creating multiplier functions
        Function<Integer, Integer> doubleFunc = createMultiplier(2);
        Function<Integer, Integer> tripleFunc = createMultiplier(3);

        // Testing the functions
        int num = 5;

        System.out.println("Double of " + num + " = " + doubleFunc.apply(num));
        System.out.println("Triple of " + num + " = " + tripleFunc.apply(num));
    }
}
