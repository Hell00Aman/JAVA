// FunctionCallCounter.java
// This program demonstrates a closure-like behavior in Java
// using a class that keeps track of how many times a function is called.

import java.util.function.Supplier;

public class FunctionCallCounter {

    public static void main(String[] args) {

        // Create a counter closure using a helper method
        Supplier<Integer> counter = createCounter();

        // Call the function multiple times and print results
        System.out.println("Call 1: " + counter.get());
        System.out.println("Call 2: " + counter.get());
        System.out.println("Call 3: " + counter.get());
    }

    // This method acts like a closure generator
    // It returns a function (Supplier) that remembers the count variable
    public static Supplier<Integer> createCounter() {

        // This array is used to store count because Java requires
        // variables used in lambda to be effectively final
        int[] count = {0};

        // Lambda function that increments and returns count
        return () -> {
            count[0]++;  // Increase count each time function is called
            return count[0];  // Return updated count
        };
    }
}
