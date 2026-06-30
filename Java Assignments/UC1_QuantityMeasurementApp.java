// UC1: Feet Measurement Equality

public class UC1_QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    static class Feet {
        private final double value; // immutable field

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals() method
        @Override
        public boolean equals(Object obj) {

            // Step 1: Same reference check
            if (this == obj) return true;

            // Step 2: Null and type check
            if (obj == null || getClass() != obj.getClass()) return false;

            // Step 3: Cast safely
            Feet other = (Feet) obj;

            // Step 4: Compare using Double.compare()
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void main(String[] args) {

        // Step 5: Create objects
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        // Step 6: Compare
        boolean result = f1.equals(f2);

        // Output result
        System.out.println("Are both measurements equal? " + result);
    }
}
