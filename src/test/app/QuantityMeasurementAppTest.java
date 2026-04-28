package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    @Test
    void testFeetTarget() {
        var result = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH),
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testInchesTarget() {
        var result = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH),
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(24.0, QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testYardTarget() {
        var result = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH),
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(0.667, result.toString().contains("0.667") ? 0.667 : 0.0, EPS);
    }

    @Test
    void testCommutativity() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(a.add(b, QuantityMeasurementApp.LengthUnit.FEET)
                .equals(b.add(a, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testZero() {
        var result = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCH),
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(1.667, result.toString().contains("1.667") ? 1.667 : 0.0, EPS);
    }

    @Test
    void testNegative() {
        var result = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(-2.0, QuantityMeasurementApp.LengthUnit.FEET),
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testNullTarget() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.QuantityLength.add(
                        new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET),
                        new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET),
                        null));
    }
}