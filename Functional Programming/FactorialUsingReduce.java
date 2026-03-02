// Program to calculate factorial of a number using reduce() method in Java

import java.util.Scanner;
import java.util.stream.LongStream;

public class FactorialUsingReduce {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a number
        System.out.print("Enter a number to find factorial: ");
        int number = scanner.nextInt();

        // Check if number is negative
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {

            // Using LongStream and reduce() to calculate factorial
            long factorial = LongStream.rangeClosed(1, number)
                    .reduce(1, (a, b) -> a * b);

            // Display the result
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        // Close scanner
        scanner.close();
    }
}
