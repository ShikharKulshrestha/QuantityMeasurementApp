package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testYardToYard_SameValue() {
        assertTrue(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)
                .equals(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)));
    }

    @Test
    void testYardToFeet_Equivalent() {
        assertTrue(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)
                .equals(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testYardToInch_Equivalent() {
        assertTrue(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)
                .equals(new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testCmToInch_Equivalent() {
        assertTrue(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CM)
                .equals(new QuantityMeasurementApp.QuantityLength(0.393701, QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testDifferentValues() {
        assertFalse(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD)
                .equals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD)));
    }

    @Test
    void testTransitiveProperty() {
        QuantityMeasurementApp.QuantityLength a =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        QuantityMeasurementApp.QuantityLength b =
                new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength c =
                new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    void testNullComparison() {
        assertFalse(new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                .equals(null));
    }

    @Test
    void testSameReference() {
        QuantityMeasurementApp.QuantityLength q =
                new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(q.equals(q));
    }
}