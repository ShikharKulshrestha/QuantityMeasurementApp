package weight;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value) || unit == null)
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    private double base() {
        return unit.convertToBase(value);
    }

    public QuantityWeight convertTo(WeightUnit target) {
        return new QuantityWeight(target.convertFromBase(base()), target);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit target) {
        double sum = this.base() + other.base();
        return new QuantityWeight(target.convertFromBase(sum), target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityWeight q = (QuantityWeight) o;
        return Double.compare(base(), q.base()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(base());
    }
}