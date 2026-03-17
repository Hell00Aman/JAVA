import java.util.Scanner;

public class DecimalToBinaryRecursive {

    // Recursive function to convert decimal to binary
    static void decimalToBinary(int n) {
        
        // Base case
        if (n == 0) {
            return;
        }

        // Recursive call
        decimalToBinary(n / 2);

        // Print remainder (binary digit)
        System.out.print(n % 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking decimal input
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        System.out.print("Binary equivalent: ");

        // If number is 0
        if (num == 0) {
            System.out.print("0");
        } 
        else {
            decimalToBinary(num);
        }

        sc.close();
    }
}
