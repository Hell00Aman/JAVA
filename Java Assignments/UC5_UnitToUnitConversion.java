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

    // Instance conversion
    public QuantityLength convertTo(LengthUnit target) {
        double feet = unit.toFeet(value);
        double converted = target.fromFeet(feet);
        return new QuantityLength(converted, target);
    }

    // Static conversion API
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value) || source == null || target == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        double feet = source.toFeet(value);
        return target.fromFeet(feet);
    }

    public static void main(String[] args) {

        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCHES)); // 12
        System.out.println(convert(3.0, LengthUnit.YARDS, LengthUnit.FEET)); // 9
        System.out.println(convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS)); // 1
        System.out.println(convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES)); // ~0.3937

        QuantityLength q = new QuantityLength(2.0, LengthUnit.YARDS);
        System.out.println(q.convertTo(LengthUnit.FEET)); // 6 feet
    }
}
