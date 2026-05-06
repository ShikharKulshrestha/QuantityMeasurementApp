package app;


import com.quantity.measurement.common.Quantity;
import com.quantity.measurement.length.LengthUnit;
import com.quantity.measurement.weight.WeightUnit;
import com.quantity.measurement.volume.VolumeUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void testLengthEquality() {
        assertTrue(new Quantity<>(1.0, LengthUnit.FEET)
                .equals(new Quantity<>(12.0, LengthUnit.INCH)));
    }

    @Test
    void testWeightEquality() {
        assertTrue(new Quantity<>(1.0, WeightUnit.KILOGRAM)
                .equals(new Quantity<>(1000.0, WeightUnit.GRAM)));
    }

    @Test
    void testCrossCategory() {
        assertFalse(new Quantity<>(1.0, LengthUnit.FEET)
                .equals(new Quantity<>(1.0, WeightUnit.KILOGRAM)));
    }

    @Test
    void testConversion() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals("Quantity(12.0, INCH)", q.convertTo(LengthUnit.INCH).toString());
    }

    @Test
    void testAddition() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0, LengthUnit.INCH), LengthUnit.FEET);

        assertTrue(result.equals(new Quantity<>(2.0, LengthUnit.FEET)));
    }

    @Test
    void testVolumeEquality() {
        assertTrue(new Quantity<>(1.0, VolumeUnit.LITRE)
                .equals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE)));
    }

    @Test
    void testVolumeConversion() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals("Quantity(1000.0, MILLILITRE)", q.convertTo(VolumeUnit.MILLILITRE).toString());
    }

    @Test
    void testVolumeAddition() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), VolumeUnit.LITRE);

        assertTrue(result.equals(new Quantity<>(2.0, VolumeUnit.LITRE)));
    }
}