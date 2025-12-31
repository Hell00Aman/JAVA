import java.util.Scanner;

public class MultiplicationTableUsingForLoop {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Print multiplication table using for loop
        for (int i = 1; i <= 10; i++) {
            // Multiply the given number with loop counter
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        // Close the scanner
        sc.close();
    }
}
