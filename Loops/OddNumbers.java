import java.util.Scanner;

public class OddNumbers {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Ask user for the limit
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // For loop to print odd numbers from 1 to n
        for (int i = 1; i <= n; i += 2) {
            System.out.println(i); // Print the odd number
        }

        // Close the scanner
        sc.close();
    }
}
