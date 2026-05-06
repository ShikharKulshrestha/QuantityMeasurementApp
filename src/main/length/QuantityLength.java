package length;


public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value) || unit == null)
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    private double base() {
        return unit.convertToBase(value);
    }

    public QuantityLength convertTo(LengthUnit target) {
        return new QuantityLength(target.convertFromBase(base()), target);
    }

    public QuantityLength add(QuantityLength other, LengthUnit target) {
        double sum = this.base() + other.base();
        return new QuantityLength(target.convertFromBase(sum), target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityLength q = (QuantityLength) o;
        return Double.compare(base(), q.base()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(base());
    }
}