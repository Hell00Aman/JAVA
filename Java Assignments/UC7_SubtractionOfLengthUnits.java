// Enum defining all supported length units with conversion factors
enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factor;

    // Constructor to initialize conversion factor
    LengthUnit(double factor) {
        this.factor = factor;
    }

    // Convert value to base unit (feet)
    public double toFeet(double value) {
        return value * factor;
    }

    // Convert value from feet to target unit
    public double fromFeet(double value) {
        return value / factor;
    }
}

// Immutable class representing a length quantity
class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    // Constructor with validation
    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // ✅ UC7: Subtraction method
    public QuantityLength subtract(QuantityLength other) {

        // Validate input
        if (other == null) {
            throw new IllegalArgumentException("Null operand");
        }

        // Convert both values to base unit (feet)
        double thisFeet = this.unit.toFeet(this.value);
        double otherFeet = other.unit.toFeet(other.value);

        // Perform subtraction in base unit
        double diffFeet = thisFeet - otherFeet;

        // Convert result back to first operand's unit
        double result = this.unit.fromFeet(diffFeet);

        // Return new immutable object
        return new QuantityLength(result, this.unit);
    }

    // Optional static method
    public static QuantityLength subtract(QuantityLength a, QuantityLength b) {
        return a.subtract(b);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static void main(String[] args) {

        // Same unit subtraction
        System.out.println(new QuantityLength(5.0, LengthUnit.FEET)
                .subtract(new QuantityLength(2.0, LengthUnit.FEET))); // 3 FEET

        // Cross unit subtraction
        System.out.println(new QuantityLength(1.0, LengthUnit.FEET)
                .subtract(new QuantityLength(12.0, LengthUnit.INCHES))); // 0 FEET

        System.out.println(new QuantityLength(12.0, LengthUnit.INCHES)
                .subtract(new QuantityLength(1.0, LengthUnit.FEET))); // 0 INCHES

        System.out.println(new QuantityLength(2.0, LengthUnit.YARDS)
                .subtract(new QuantityLength(3.0, LengthUnit.FEET))); // 1 YARD

        System.out.println(new QuantityLength(5.08, LengthUnit.CENTIMETERS)
                .subtract(new QuantityLength(1.0, LengthUnit.INCHES))); // ~2.54 CM

        // Negative result case
        System.out.println(new QuantityLength(2.0, LengthUnit.FEET)
                .subtract(new QuantityLength(5.0, LengthUnit.FEET))); // -3 FEET
    }
}
