// ✅ Standalone Enum for Weight Units (Similar to UC8 LengthUnit)
enum WeightUnit {

    KILOGRAM(1.0),     // Base unit
    GRAM(0.001),       // 1 g = 0.001 kg
    POUND(0.453592);   // 1 lb ≈ 0.453592 kg

    private final double factor; // conversion factor to base unit (kg)

    // Constructor
    WeightUnit(double factor) {
        this.factor = factor;
    }

    // Convert value to base unit (kg)
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    // Convert from base unit (kg) to target unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}


// ✅ QuantityWeight Class (Handles logic, uses WeightUnit)
class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    // Constructor with validation
    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // ✅ Convert to another unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit null");
        }

        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);

        return new QuantityWeight(result, targetUnit);
    }

    // ✅ Addition (result in target unit)
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sum);

        return new QuantityWeight(result, targetUnit);
    }

    // ✅ Equality Check
    @Override
    public boolean equals(Object obj) {

        // Same reference
        if (this == obj) return true;

        // Null or different class (prevents length vs weight comparison)
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        // Compare with precision
        return Math.abs(base1 - base2) < 0.0001;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    // ✅ Demo Main Method
    public static void main(String[] args) {

        // Equality
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM))); // true

        // Conversion
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.POUND)); // ~2.20462 lb

        // Addition
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(500.0, WeightUnit.GRAM), WeightUnit.KILOGRAM)); // 1.5 kg

        // Cross unit addition
        System.out.println(new QuantityWeight(2.0, WeightUnit.POUND)
                .add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), WeightUnit.POUND));
    }
}
