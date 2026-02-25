// This program takes a list of numbers and a function (square or cube)
// as input and applies the selected function to all numbers using
// Java's functional interface.

import java.util.*;
import java.util.function.Function;

public class FunctionApply {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking list size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();

        // Taking numbers as input
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        // Choosing function type
        System.out.print("Enter function (square/cube): ");
        String choice = sc.next();

        // Assigning function dynamically
        Function<Integer, Integer> operation;

        if (choice.equalsIgnoreCase("square")) {
            operation = x -> x * x;
        } else if (choice.equalsIgnoreCase("cube")) {
            operation = x -> x * x * x;
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        // Applying function to all numbers
        System.out.println("Result:");
        for (int num : numbers) {
            System.out.println(operation.apply(num));
        }

        sc.close();
    }
}
