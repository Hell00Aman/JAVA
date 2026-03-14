// FileName: GenerateNumbersRecursively.java

import java.util.Scanner;   // Import Scanner class to take user input

public class GenerateNumbersRecursively {

    // Recursive function to print numbers from 1 to n
    public static void generateNumbers(int n) {

        // Base case: stop recursion when n becomes 0
        if (n == 0) {
            return;
        }

        // Recursive call to print numbers from 1 to n-1
        generateNumbers(n - 1);

        // Print the current number after returning from recursion
        System.out.print(n + " ");
    }

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter a number
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Call the recursive function
        generateNumbers(n);
    }
}
