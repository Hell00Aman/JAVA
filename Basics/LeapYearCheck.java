import java.util.Scanner;

public class LeapYearCheck {

    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a year
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Check if the year is divisible by 4
        if (year % 4 == 0 && year % 100 != 0) {
            // Divisible by 4 but not by 100 → Leap year
            System.out.println(year + " is a leap year.");
        }
        // If the year is divisible by 100
        else if (year % 100 == 0) {

            // Further check if it is divisible by 400
            if (year % 400 == 0) {
                // Divisible by 400 → Leap year
                System.out.println(year + " is a leap year.");
            } else {
                // Divisible by 100 but not by 400 → Not a leap year
                System.out.println(year + " is not a leap year.");
            }
        }
        // If none of the above conditions are true
        else {
            // Not divisible by 4 → Not a leap year
            System.out.println(year + " is not a leap year.");
        }

        // Close the scanner
        sc.close();
    }
}
