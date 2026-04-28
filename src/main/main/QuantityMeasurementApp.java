package main;

public class QuantityMeasurementApp {

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
            return unit.convertToBaseUnit(value);
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            double base = toBaseUnit();
            return new QuantityLength(targetUnit.convertFromBaseUnit(base), targetUnit);
        }

        public QuantityLength add(QuantityLength other) {
            if (other == null) throw new IllegalArgumentException("Null operand");
            double sumBase = this.toBaseUnit() + other.toBaseUnit();
            return new QuantityLength(this.unit.convertFromBaseUnit(sumBase), this.unit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            double sumBase = this.toBaseUnit() + other.toBaseUnit();
            return new QuantityLength(targetUnit.convertFromBaseUnit(sumBase), targetUnit);
        }

        public static double convert(double value, LengthUnit source, LengthUnit target) {
            if (!Double.isFinite(value) || source == null || target == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            double base = source.convertToBaseUnit(value);
            return target.convertFromBaseUnit(base);
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

        Object LengthUnit;
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(a.convertTo(LengthUnit.INCH));          // 12 INCH
        System.out.println(a.add(b, LengthUnit.FEET));             // 2 FEET
        System.out.println(a.add(b, LengthUnit.YARD));             // ~0.667 YARD
        System.out.println(a.equals(new QuantityLength(12.0, LengthUnit.INCH))); // true
    }
}}