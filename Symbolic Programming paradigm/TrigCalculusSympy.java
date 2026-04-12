// File: TrigCalculusSympy.java

// This program shows the derivative and definite integral of:
// f(x) = sin(x) * cos(x)

public class TrigCalculusSympy {

    public static void main(String[] args) {

        // Given function
        System.out.println("Given Function: f(x) = sin(x) * cos(x)");

        // Derivative using identity:
        // d/dx [sin(x)cos(x)] = cos^2(x) - sin^2(x)
        // = cos(2x)
        System.out.println("Derivative f'(x) = cos(2x)");

        // Definite Integral:
        // ∫ sin(x)cos(x) dx = (1/2)sin^2(x)
        // Evaluate from 0 to π/2:
        // (1/2)[sin^2(π/2) - sin^2(0)] = (1/2)(1 - 0) = 1/2
        System.out.println("Definite Integral from 0 to π/2 = 1/2");
    }
}
