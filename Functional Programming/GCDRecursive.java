// File: GCDRecursive.java

public class GCDRecursive {

    // Recursive function to find GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {

        // Base case: if second number becomes 0
        // then first number is the GCD
        if (b == 0) {
            return a;
        }

        // Recursive call:
        // gcd(a, b) = gcd(b, a % b)
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        // Calling recursive function
        int result = gcd(num1, num2);

        // Output result
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
    }
}
