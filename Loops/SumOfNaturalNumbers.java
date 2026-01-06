import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the value of n from the user
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;   // Variable to store sum
        int i = 1;     // Loop counter starts from 1

        // While loop to calculate sum from 1 to n
        while (i <= n) {
            sum = sum + i; // Add current number to sum
            i++;           // Increment counter
        }

        // Display the result
        System.out.println("Sum of natural numbers = " + sum);
    }
}
