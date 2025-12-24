import java.util.Scanner;  // Import Scanner class for user input

public class VendingMachine350c {

    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Display menu options
        System.out.println("Press 1 for juice or 2 for soda.");

        // Ask user for their choice
        int choice = input.nextInt();

        // Check the user's choice using if-else statements
        if (choice == 1) {
            System.out.println("Dispensing juice.");
        } 
        else if (choice == 2) {
            System.out.println("Dispensing soda.");
        } 
        else {
            System.out.println("Invalid choice.");
        }

        // Close the Scanner
        input.close();
    }
}
