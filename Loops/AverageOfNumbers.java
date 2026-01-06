import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user how many numbers they want to enter
        System.out.print("Enter count of numbers: ");
        int n = sc.nextInt();

        int count = 0;     // Counter for numbers
        double sum = 0;    // Stores sum of numbers

        // While loop to read numbers and add them
        while (count < n) {
            System.out.print("Enter number: ");
            sum = sum + sc.nextDouble();
            count++;       // Increment counter
        }

        // Calculate and display average
        double average = sum / n;
        System.out.println("Average = " + average);
    }
}
