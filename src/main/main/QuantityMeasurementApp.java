package main;

public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeet;
        }
    }

    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (!Double.isFinite(value) || unit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        private static double addInBase(double a, double b) {
            return a + b;
        }

        public QuantityLength add(QuantityLength other) {
            if (other == null) throw new IllegalArgumentException("Null operand");
            double sumBase = addInBase(this.toBaseUnit(), other.toBaseUnit());
            return new QuantityLength(this.unit.fromFeet(sumBase), this.unit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            double sumBase = addInBase(this.toBaseUnit(), other.toBaseUnit());
            return new QuantityLength(targetUnit.fromFeet(sumBase), targetUnit);
        }

        public static QuantityLength add(QuantityLength a, QuantityLength b, LengthUnit targetUnit) {
            if (a == null || b == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            double sumBase = addInBase(a.toBaseUnit(), b.toBaseUnit());
            return new QuantityLength(targetUnit.fromFeet(sumBase), targetUnit);
        }

        public static double convert(double value, LengthUnit source, LengthUnit target) {
            if (!Double.isFinite(value) || source == null || target == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            double base = source.toFeet(value);
            return target.fromFeet(base);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityLength other = (QuantityLength) obj;
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toBaseUnit());
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(a.add(b, LengthUnit.FEET));    // 2 FEET
        System.out.println(a.add(b, LengthUnit.INCH));    // 24 INCH
        System.out.println(a.add(b, LengthUnit.YARD));    // ~0.667 YARD

        QuantityLength c = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength d = new QuantityLength(1.0, LengthUnit.YARD);

        System.out.println(QuantityLength.add(c, d, LengthUnit.FEET)); // 6 FEET
    }
}