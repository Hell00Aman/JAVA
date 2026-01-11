public class FactorialDoWhile {
    public static void main(String[] args) {
        int number = 5;        // Given non-negative number
        int i = 1;             // Loop counter
        long factorial = 1;    // Variable to store factorial result

        // do-while loop to calculate factorial
        do {
            factorial *= i;    // Multiply factorial by current value
            i++;               // Increment counter
        } while (i <= number); // Loop continues until i exceeds number

        // Display the factorial result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
