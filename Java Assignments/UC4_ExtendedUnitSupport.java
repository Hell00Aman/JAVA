enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),                 // 1 yard = 3 feet
    CENTIMETER(0.0328084);     // 1 cm = 0.0328084 feet

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toFeet(double value) {
        return value * factor;
    }
}

class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    private double toFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        System.out.println(q1.equals(q2)); // true

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q4 = new QuantityLength(36.0, LengthUnit.INCH);
        System.out.println(q3.equals(q4)); // true

        QuantityLength q5 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength q6 = new QuantityLength(0.393701, LengthUnit.INCH);
        System.out.println(q5.equals(q6)); // true

        QuantityLength q7 = new QuantityLength(2.0, LengthUnit.YARD);
        QuantityLength q8 = new QuantityLength(72.0, LengthUnit.INCH);
        System.out.println(q7.equals(q8)); // true
    }
}
