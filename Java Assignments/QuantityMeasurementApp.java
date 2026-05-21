/**
 * Main application class responsible for managing quantity measurements
 * and verifying equality between measurement values.
 */
public class QuantityMeasurementApp {

    /**
     * Inner class representing a measurement unit in Feet.
     * Designed to be immutable to guarantee data integrity.
     */
    public static class Feet {
        // Private final field ensuring the measurement value cannot be modified after creation
        private final double value;

        /**
         * Constructor to initialize the feet measurement value.
         * @param value The numerical value of the measurement in feet.
         */
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Overrides the standard Object equals method to implement value-based equality.
         * Accounts for reference symmetry, type-safety, null handling, and floating-point precision.
         */
        @Override
        public boolean equals(Object obj) {
            // 1. Reflexive check: If both references point to the same memory address, they are equal
            if (this == obj) {
                return true;
            }

            // 2. Null and Type safety check: If the incoming object is null or belongs to a different class, they cannot be equal
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            // 3. Type casting: Safely cast the incoming object to the Feet type now that the class matches
            Feet other = (Feet) obj;

            // 4. Floating-point comparison: Use Double.compare() instead of '==' to avoid precision errors common in doubles
            return Double.compare(this.value, other.value) == 0;
        }
    }

    /**
     * Main entry point of the application to demonstrate the equality logic.
     */
    public static void main(String[] args) {
        // Instantiate two Feet objects with matching values
        Feet distance1 = new Feet(1.0);
        Feet distance2 = new Feet(1.0);

        // Perform the comparison check using the overridden equals method
        boolean isEqual = distance1.equals(distance2);

        // Print output to verify the system works as expected
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + isEqual + ")");
    }
}
