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
    }

    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return unit.toFeet(value);
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
    }

    public static void main(String[] args) {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.CM);
        QuantityLength q4 = new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println(q1.equals(q2));
        System.out.println(q3.equals(q4));
    }
}