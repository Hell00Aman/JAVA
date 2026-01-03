// Program to calculate Simple Interest using a for loop
import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Read principal amount
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();

        // Read rate of interest
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        // Read number of years
        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double interest = 0;

        // Calculate simple interest using for loop
        for (int i = 1; i <= years; i++) {
            interest += (principal * rate) / 100;
        }

        // Print the simple interest
        System.out.println("Simple Interest = " + interest);

        // Close scanner
        sc.close();
    }
}
