import java.util.Scanner;

public class ValidatePositiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number; // Variable to store user input

        // do-while loop to keep asking until a positive number is entered
        do {
            System.out.print("Enter a positive number: ");
            number = sc.nextInt();   // Read user input
        } while (number <= 0);       // Repeat if input is not positive

        // Display valid input
        System.out.println("You entered a valid positive number: " + number);
        sc.close(); // Close the scanner
    }
}
