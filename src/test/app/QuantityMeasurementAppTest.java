package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCH),
                EPS);
    }

    @Test
    void testEquality() {
        assertTrue(new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH)));
    }

    @Test
    void testAdditionWithTarget() {
        var result = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH),
                        LengthUnit.YARD);

        assertEquals(0.667, result.toString().contains("0.667") ? 0.667 : 0.0, EPS);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityMeasurementApp.QuantityLength(1.0, null));
    }
}