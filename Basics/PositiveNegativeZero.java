import java.util.Scanner;
public class PositiveNegativeZero {
    public static void main(String[] args) {
        // Create Scanner object to read input from user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Check if the number is positive
        if (num > 0) {
            System.out.println("The number is positive.");
        }
        // Check if the number is negative
        else if (num < 0) {
            System.out.println("The number is negative.");
        }
        // If the number is neither positive nor negative
        else {
            System.out.println("The number is zero.");
        }

        // Close the scanner
        sc.close();
    }
}
