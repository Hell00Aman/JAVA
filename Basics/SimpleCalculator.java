import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Display menu
        System.out.println("Enter 1 for addition or 2 for subtraction:");

        // Read user choice
        int choice = sc.nextInt();

        // Check choice using if-else
        if (choice == 1) {
            // Addition
            System.out.println("Enter first number:");
            int a = sc.nextInt();

            System.out.println("Enter second number:");
            int b = sc.nextInt();

            System.out.println("Sum = " + (a + b));

        } else if (choice == 2) {
            // Subtraction
            System.out.println("Enter first number:");
            int a = sc.nextInt();

            System.out.println("Enter second number:");
            int b = sc.nextInt();

            System.out.println("Difference = " + (a - b));

        } else {
            // Invalid choice
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }

        // Close scanner
        sc.close();
    }
}
