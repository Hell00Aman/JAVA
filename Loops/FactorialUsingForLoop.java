import java.util.Scanner;

public class FactorialUsingForLoop {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        int num = sc.nextInt();

        // Initialize factorial variable
        long factorial = 1;

        // Calculate factorial using for loop
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }

        // Print the result
        System.out.println("Factorial of " + num + " is: " + factorial);

        // Close the scanner
        sc.close();
    }
}
