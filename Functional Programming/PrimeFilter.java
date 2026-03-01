// Program to filter prime numbers from a given list using filter() in Java

import java.util.*;
import java.util.stream.*;

public class PrimeFilter {

    // Method to check whether a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Divisible means not prime
            }
        }
        return true; // Number is prime
    }

    public static void main(String[] args) {

        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15);

        // Using stream() and filter() to get only prime numbers
        List<Integer> primeNumbers = numbers.stream()
                .filter(PrimeFilter::isPrime) // Keep only prime numbers
                .collect(Collectors.toList());

        // Printing the result
        System.out.println("Original List: " + numbers);
        System.out.println("Prime Numbers: " + primeNumbers);
    }
}
