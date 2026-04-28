package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testFeetPlusFeet() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET));

        assertEquals(3.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET).toString().contains("3.0") ? 3.0 : 0.0);
    }

    @Test
    void testFeetPlusInches() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH));

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testInchesPlusFeet() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH)
                        .add(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET));

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(24.0, QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testYardPlusFeet() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)
                        .add(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET));

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD)));
    }

    @Test
    void testCmPlusInch() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(2.54, QuantityMeasurementApp.LengthUnit.CM)
                        .add(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH));

        assertEquals(5.08, result.convertTo(QuantityMeasurementApp.LengthUnit.CM).toString().contains("5.08") ? 5.08 : 0.0, 1e-2);
    }

    @Test
    void testCommutativity() {
        QuantityMeasurementApp.QuantityLength a =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength b =
                new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(a.add(b).equals(b.add(a).convertTo(a.unit)));
    }

    @Test
    void testZero() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCH));

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testNegative() {
        QuantityMeasurementApp.QuantityLength result =
                new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(-2.0, QuantityMeasurementApp.LengthUnit.FEET));

        assertTrue(result.equals(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testNullOperand() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                        .add(null));
    }
}