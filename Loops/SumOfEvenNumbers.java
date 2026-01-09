public class SumOfEvenNumbers {
    public static void main(String[] args) {
        int n = 20;          // Given number
        int i = 1;           // Loop counter
        int sum = 0;         // Variable to store sum of even numbers

        // do-while loop to check numbers from 1 to n
        do {
            if (i % 2 == 0) {    // Check if the number is even
                sum += i;       // Add even number to sum
            }
            i++;                // Increment counter
        } while (i <= n);        // Loop continues until i exceeds n

        // Display the result
        System.out.println("Sum of even numbers from 1 to " + n + " is: " + sum);
    }
}
