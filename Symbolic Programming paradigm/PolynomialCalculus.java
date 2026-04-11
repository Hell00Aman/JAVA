// File: PolynomialCalculus.java

// This program computes the derivative and integral of the function:
// f(x) = 2x^4 - 3x^2 + 5

public class PolynomialCalculus {

    public static void main(String[] args) {

        // Original function
        System.out.println("Given Function: f(x) = 2x^4 - 3x^2 + 5");

        // Derivative calculation:
        // d/dx (2x^4) = 8x^3
        // d/dx (-3x^2) = -6x
        // d/dx (5) = 0
        System.out.println("Derivative f'(x) = 8x^3 - 6x");

        // Integral calculation:
        // ∫2x^4 dx = (2/5)x^5
        // ∫-3x^2 dx = -x^3
        // ∫5 dx = 5x
        System.out.println("Integral ∫f(x)dx = (2/5)x^5 - x^3 + 5x + C");
    }
}
