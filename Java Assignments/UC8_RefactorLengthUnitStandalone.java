// ✅ Standalone Enum (UC8 Core Change)
// Handles ALL conversion logic (SRP applied)
enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factor; // conversion factor to base unit (feet)

    // Constructor
    LengthUnit(double factor) {
        this.factor = factor;
    }

    // ✅ Convert any unit value → Base Unit (Feet)
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    // ✅ Convert Base Unit (Feet) → Target Unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}


// ✅ Quantity Class (Now Simplified)
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

    // ✅ Convert to another unit (delegates to enum)
    public QuantityLength convertTo(LengthUnit targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);
        return new QuantityLength(result, targetUnit);
    }

    // ✅ Addition (UC6 compatible)
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sum);

        return new QuantityLength(result, targetUnit);
    }

    // ✅ Equality check (UC1–UC4 compatible)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.0001; // epsilon comparison
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    // ✅ Demo (Main Method)
    public static void main(String[] args) {

        // Conversion
        System.out.println(new QuantityLength(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES)); // 12 INCHES

        // Addition
        System.out.println(new QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.FEET)); // 2 FEET

        // Equality
        System.out.println(new QuantityLength(36.0, LengthUnit.INCHES)
                .equals(new QuantityLength(1.0, LengthUnit.YARDS))); // true

        // Cross unit addition
        System.out.println(new QuantityLength(1.0, LengthUnit.YARDS)
                .add(new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.YARDS)); // 2 YARDS

        // CM Conversion
        System.out.println(new QuantityLength(2.54, LengthUnit.CENTIMETERS)
                .convertTo(LengthUnit.INCHES)); // ~1 INCH
    }
}
