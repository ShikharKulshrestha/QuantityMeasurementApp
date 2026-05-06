package common;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (!Double.isFinite(value) || unit == null)
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    private double base() {
        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        double base = base();
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        double sum = this.base() + other.base();
        return new Quantity<>(unit.convertFromBaseUnit(sum), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sum = this.base() + other.base();
        return new Quantity<>(round(targetUnit.convertFromBaseUnit(sum)), targetUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (this.unit.getClass() != other.unit.getClass()) return false;

        return Double.compare(this.base(), other.base()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(base());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}