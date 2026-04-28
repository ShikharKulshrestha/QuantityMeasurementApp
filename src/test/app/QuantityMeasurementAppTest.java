package app;
import org.junit.jupiter.api.Test;
import main.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {


    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

        assertEquals(f1, f2, "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertNotEquals(f1, f2, "1.0 ft should NOT be equal to 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertNotEquals(null, f1, "Object should not be equal to null");
    }

    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertEquals(f1, f1, "Same reference should be equal");
    }

    @Test
    void testEquality_DifferentType() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertNotEquals("1.0", f1, "Feet should not equal a String");
    }
}
