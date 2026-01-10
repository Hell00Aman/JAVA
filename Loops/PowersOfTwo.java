public class PowersOfTwo {
    public static void main(String[] args) {
        int exponent = 5;     // Given exponent limit
        int i = 0;            // Counter for exponent
        int result = 1;       // Stores power of 2 (2^0 = 1)

        // do-while loop to print powers of 2
        do {
            System.out.println("2^" + i + " = " + result); // Print current power
            result *= 2;      // Multiply result by 2 for next power
            i++;              // Increment exponent counter
        } while (i <= exponent); // Loop runs until exponent limit
    }
}
