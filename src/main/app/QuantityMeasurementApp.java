package app;

import length.*;
import weight.*;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Length
        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCH);
        System.out.println(l1.equals(l2));

        // Weight
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        System.out.println(w1.equals(w2));

        // Conversion
        System.out.println(w1.convertTo(WeightUnit.POUND));

        // Addition
        System.out.println(w1.add(w2, WeightUnit.KILOGRAM));
    }
}