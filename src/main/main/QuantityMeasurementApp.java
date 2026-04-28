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

        public QuantityLength convertTo(LengthUnit targetUnit) {
            double base = toBaseUnit();
            double converted = targetUnit.fromFeet(base);
            return new QuantityLength(converted, targetUnit);
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

        System.out.println(QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
        System.out.println(QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET));
        System.out.println(QuantityLength.convert(36.0, LengthUnit.INCH, LengthUnit.YARD));
        System.out.println(QuantityLength.convert(1.0, LengthUnit.CM, LengthUnit.INCH));

        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println(q.convertTo(LengthUnit.INCH));
    }
}