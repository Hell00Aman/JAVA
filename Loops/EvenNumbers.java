import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the given number
        int n = sc.nextInt();

        // For loop from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if the number is even
            if (i % 2 == 0) {
                // Print even number
                System.out.println(i);
            }
        }

        // Close the scanner
        sc.close();
    }
}
