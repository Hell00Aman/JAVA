enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toFeet(double value) {
        return value * factor;
    }

    public double fromFeet(double value) {
        return value / factor;
    }
}

class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // ✅ Addition method (core of UC6)
    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Null operand");
        }

        double thisFeet = this.unit.toFeet(this.value);
        double otherFeet = other.unit.toFeet(other.value);

        double sumFeet = thisFeet + otherFeet;

        double result = this.unit.fromFeet(sumFeet);

        return new QuantityLength(result, this.unit);
    }

    // Optional static method
    public static QuantityLength add(QuantityLength a, QuantityLength b) {
        return a.add(b);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static void main(String[] args) {

        System.out.println(new QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityLength(2.0, LengthUnit.FEET))); // 3 FEET

        System.out.println(new QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityLength(12.0, LengthUnit.INCHES))); // 2 FEET

        System.out.println(new QuantityLength(12.0, LengthUnit.INCHES)
                .add(new QuantityLength(1.0, LengthUnit.FEET))); // 24 INCHES

        System.out.println(new QuantityLength(1.0, LengthUnit.YARDS)
                .add(new QuantityLength(3.0, LengthUnit.FEET))); // 2 YARDS

        System.out.println(new QuantityLength(2.54, LengthUnit.CENTIMETERS)
                .add(new QuantityLength(1.0, LengthUnit.INCHES))); // ~5.08 CM
    }
}
