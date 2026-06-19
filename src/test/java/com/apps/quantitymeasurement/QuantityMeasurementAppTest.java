package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    // --- Legacy Feet Equality Tests (UC1 & UC2 compatibility) ---

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2), "Two Feet objects with the same value should be equal");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2), "Two Feet objects with different values should not be equal");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet = new Feet(1.0);
        assertFalse(feet.equals(null), "Feet object compared with null should return false");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet = new Feet(1.0);
        Object obj = new Object();
        assertFalse(feet.equals(obj), "Feet object compared with an object of different class should return false");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(1.0);
        assertTrue(feet.equals(feet), "Feet object compared with itself should return true");
    }

    // --- Legacy Inches Equality Tests (UC1 & UC2 compatibility) ---

    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        assertTrue(inches1.equals(inches2), "Two Inches objects with the same value should be equal");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(2.0);
        assertFalse(inches1.equals(inches2), "Two Inches objects with different values should not be equal");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches = new Inches(1.0);
        assertFalse(inches.equals(null), "Inches object compared with null should return false");
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inches = new Inches(1.0);
        Object obj = new Object();
        assertFalse(inches.equals(obj), "Inches object compared with an object of different class should return false");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches = new Inches(1.0);
        assertTrue(inches.equals(inches), "Inches object compared with itself should return true");
    }

    // --- UC3 Length / Quantity Equality & Inequality Tests ---

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 Feet should equal 1.0 Feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2), "1.0 Inch should equal 1.0 Inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches), "1.0 Feet should equal 12.0 Inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(inches.equals(feet), "12.0 Inches should equal 1.0 Feet");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 Feet should not equal 2.0 Feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2), "1.0 Inch should not equal 2.0 Inches");
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        }, "Creating a Length with a null unit should throw IllegalArgumentException");
    }

    @Test
    public void testEquality_SameReference() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(feet.equals(feet), "Length object compared with itself should return true");
    }

    @Test
    public void testEquality_NullComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(feet.equals(null), "Length object compared with null should return false");
    }

    @Test
    public void testEquality_DifferentClass() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Object obj = new Object();
        assertFalse(feet.equals(obj), "Length object compared with object of different class should return false");
    }

    // --- Legacy / UC3 tests matching UI screenshot ---

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(1.0, Length.LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length feet1 = new Length(2.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    // --- UC4 Yards and Centimeters Test Cases ---

    @Test
    public void testEquality_YardToYard_SameValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(yard1.equals(yard2), "1.0 Yard should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2), "1.0 Yard should not equal 2.0 Yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(yard.equals(feet), "1.0 Yard should equal 3.0 Feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(feet.equals(yard), "3.0 Feet should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches), "1.0 Yard should equal 36.0 Inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(inches.equals(yard), "36.0 Inches should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(yard.equals(feet), "1.0 Yard should not equal 2.0 Feet");
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches), "1.0 Centimeter should equal 0.393701 Inches");
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(cm.equals(feet), "1.0 Centimeter should not equal 1.0 Foot");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches), "Transitive property: yard equals feet, feet equals inches, yard equals inches");
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }

    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm));
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertFalse(cm.equals(null));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(feet) && feet.equals(inches));
    }

    // --- Specific UC4 tests matching UI screenshot ---

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(cm.equals(feet));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(1.0, Length.LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        // Reflexive
        assertTrue(yard.equals(yard));

        // Symmetric
        assertTrue(yard.equals(feet) && feet.equals(yard));

        // Transitive
        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET
        ));
    }

    // --- UC5 Unit Conversion Test Cases ---

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0, QuantityMeasurementApp.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0, QuantityMeasurementApp.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET), 1e-6);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0, QuantityMeasurementApp.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(2.0, QuantityMeasurementApp.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS), 1e-6);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(1.0, QuantityMeasurementApp.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_FeatToYard() {
        assertEquals(2.0, QuantityMeasurementApp.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS), 1e-6);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double originalValue = 10.0;
        double feetToInches = QuantityMeasurementApp.convert(originalValue, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double roundTrip = QuantityMeasurementApp.convert(feetToInches, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(originalValue, roundTrip, 1e-6);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(0.0, QuantityMeasurementApp.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(-12.0, QuantityMeasurementApp.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, null, Length.LengthUnit.FEET);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, Length.LengthUnit.FEET, null);
        });
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.NEGATIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
    }

    @Test
    public void testConversion_PrecisionTolerance() {
        double result = QuantityMeasurementApp.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        // Asserting that it is approximately 0.393701 within standard epsilon delta (1e-6)
        assertEquals(0.393701, result, 1e-6);
    }

    // --- UC7 Addition Test Cases ---

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, Length.LengthUnit.FEET);
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, Length.LengthUnit.INCHES);
        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, Length.LengthUnit.YARDS);
        // 2.0 feet = 0.66667 yards
        assertEquals(new Length(2.0 / 3.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length cm = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(cm, inch, Length.LengthUnit.CENTIMETERS);
        // 2.54 cm + 1.0 inch (in CENTIMETERS)
        // 1 inch = 2.54 cm, total is 5.08 cm
        assertEquals(new Length(5.08, Length.LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(yard, feet, Length.LengthUnit.YARDS);
        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.add(inches, yard, Length.LengthUnit.YARDS);
        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        
        Length result1 = QuantityMeasurementApp.add(yard, feet, Length.LengthUnit.FEET);
        Length result2 = QuantityMeasurementApp.add(feet, yard, Length.LengthUnit.FEET);
        
        assertEquals(result1, result2);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        Length feet = new Length(5.0, Length.LengthUnit.FEET);
        Length inches = new Length(0.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, Length.LengthUnit.YARDS);
        assertEquals(new Length(5.0 / 3.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length feet1 = new Length(5.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(-2.0, Length.LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2, Length.LengthUnit.INCHES);
        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(feet, inches, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(feet, null, Length.LengthUnit.FEET);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(null, inches, Length.LengthUnit.FEET);
        });
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length yard1 = new Length(100.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(100.0, Length.LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.add(yard1, yard2, Length.LengthUnit.INCHES);
        assertEquals(new Length(7200.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length inch1 = new Length(36.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(36.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(inch1, inch2, Length.LengthUnit.YARDS);
        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);

        // Sum of all: 1 ft + 1 ft + 3 ft + 1 ft = 6 ft
        Length sum1 = QuantityMeasurementApp.add(feet, inches, Length.LengthUnit.FEET); // 2 ft
        Length sum2 = QuantityMeasurementApp.add(sum1, yards, Length.LengthUnit.FEET);  // 5 ft
        Length sum3 = QuantityMeasurementApp.add(sum2, cm, Length.LengthUnit.FEET);     // 6 ft

        assertEquals(new Length(6.0, Length.LengthUnit.FEET), sum3);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(39.3701, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(cm, inch, Length.LengthUnit.FEET);
        double expectedFeet = (100.0 * (0.393701 / 12.0)) + (39.3701 / 12.0);
        assertEquals(new Length(expectedFeet, Length.LengthUnit.FEET), result);
    }
}

