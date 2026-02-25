// This program demonstrates assigning a function to a variable
// using Java functional interface. The function checks whether
// a number is even and is used to test multiple numbers.

import java.util.function.Predicate;

public class EvenFunction {
    public static void main(String[] args) {
        
        // Assigning a lambda function to a Predicate variable
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Testing multiple numbers
        int[] numbers = {2, 5, 8, 11, 14};

        for (int n : numbers) {
            if (isEven.test(n)) {
                System.out.println(n + " is Even");
            } else {
                System.out.println(n + " is Odd");
            }
        }
    }
}
