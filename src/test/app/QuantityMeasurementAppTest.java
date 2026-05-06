package app;


import com.quantity.measurement.common.Quantity;
import com.quantity.measurement.length.LengthUnit;
import com.quantity.measurement.weight.WeightUnit;
import com.quantity.measurement.volume.VolumeUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void testEquality() {
        assertTrue(new Quantity<>(1.0, LengthUnit.FEET)
                .equals(new Quantity<>(12.0, LengthUnit.INCH)));
    }

    @Test
    void testAddition() {
        assertTrue(new Quantity<>(1.0, LengthUnit.FEET)
                .add(new Quantity<>(12.0, LengthUnit.INCH), LengthUnit.FEET)
                .equals(new Quantity<>(2.0, LengthUnit.FEET)));
    }

    @Test
    void testSubtraction() {
        assertTrue(new Quantity<>(10.0, LengthUnit.FEET)
                .subtract(new Quantity<>(6.0, LengthUnit.INCH))
                .equals(new Quantity<>(9.5, LengthUnit.FEET)));
    }

    @Test
    void testSubtractionNegative() {
        assertTrue(new Quantity<>(5.0, LengthUnit.FEET)
                .subtract(new Quantity<>(10.0, LengthUnit.FEET))
                .equals(new Quantity<>(-5.0, LengthUnit.FEET)));
    }

    @Test
    void testDivision() {
        assertEquals(2.0,
                new Quantity<>(10.0, LengthUnit.FEET)
                        .divide(new Quantity<>(5.0, LengthUnit.FEET)));
    }

    @Test
    void testDivisionCrossUnit() {
        assertEquals(1.0,
                new Quantity<>(24.0, LengthUnit.INCH)
                        .divide(new Quantity<>(2.0, LengthUnit.FEET)));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                new Quantity<>(10.0, LengthUnit.FEET)
                        .divide(new Quantity<>(0.0, LengthUnit.FEET)));
    }

    @Test
    void testVolume() {
        assertTrue(new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE)));
    }

    @Test
    void testCrossCategory() {
        assertFalse(new Quantity<>(1.0, LengthUnit.FEET)
                .equals(new Quantity<>(1.0, WeightUnit.KILOGRAM)));
    }
}