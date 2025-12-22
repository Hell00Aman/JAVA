import java.util.Scanner; // Import Scanner class for user input

public class EvenOddCheck {
    public static void main(String[] args) {

        // Create Scanner object to read input from keyboard
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Check if the number is even or odd
        if (num % 2 == 0) {
            // If remainder is 0, number is even
            System.out.println("The number is even.");
        } else {
            // Otherwise, number is odd
            System.out.println("The number is odd.");
        }

        // Close the scanner
        sc.close();
    }
}
