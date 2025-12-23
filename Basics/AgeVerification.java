import java.util.Scanner;  // Import Scanner class for user input

public class AgeVerification350c {

    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Declare variable to store age
        int age;

        // Ask the user to enter their age
        System.out.print("Enter your age: ");
        age = input.nextInt();

        // Check voting eligibility using if-else
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        // Close the Scanner
        input.close();
    }
}
