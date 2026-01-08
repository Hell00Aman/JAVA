import java.util.Scanner;

public class cmnt {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Ask user for the number
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Initialize counter
        int i = 1;

        // While loop to print numbers from 1 to n
        while (i <= n) {
            System.out.println(i);
            i++;
        }

        // Close scanner
        sc.close();
    }
}
