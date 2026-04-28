package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPS);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityMeasurementApp.QuantityLength.convert(24.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET),
                EPS);
    }

    @Test
    void testYardToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.YARD,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPS);
    }

    @Test
    void testInchesToYard() {
        assertEquals(2.0,
                QuantityMeasurementApp.QuantityLength.convert(72.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.YARD),
                EPS);
    }

    @Test
    void testCmToInches() {
        assertEquals(1.0,
                QuantityMeasurementApp.QuantityLength.convert(2.54,
                        QuantityMeasurementApp.LengthUnit.CM,
                        QuantityMeasurementApp.LengthUnit.INCH),
                1e-3);
    }

    @Test
    void testRoundTrip() {
        double v = 5.0;
        double converted =
                QuantityMeasurementApp.QuantityLength.convert(v,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH);

        double back =
                QuantityMeasurementApp.QuantityLength.convert(converted,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(v, back, EPS);
    }

    @Test
    void testZeroValue() {
        assertEquals(0.0,
                QuantityMeasurementApp.QuantityLength.convert(0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPS);
    }

    @Test
    void testNegativeValue() {
        assertEquals(-12.0,
                QuantityMeasurementApp.QuantityLength.convert(-1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPS);
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.QuantityLength.convert(Double.NaN,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH));
    }
}}