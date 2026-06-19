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
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 Feet should equal 1.0 Feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2), "1.0 Inch should equal 1.0 Inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches), "1.0 Feet should equal 12.0 Inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(inches.equals(feet), "12.0 Inches should equal 1.0 Feet");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 Feet should not equal 2.0 Feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(2.0, LengthUnit.INCHES);
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
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet.equals(feet), "Length object compared with itself should return true");
    }

    @Test
    public void testEquality_NullComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertFalse(feet.equals(null), "Length object compared with null should return false");
    }

    @Test
    public void testEquality_DifferentClass() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Object obj = new Object();
        assertFalse(feet.equals(obj), "Length object compared with object of different class should return false");
    }

    // --- Legacy / UC3 tests matching UI screenshot ---

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(2.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(1.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length feet1 = new Length(2.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    // --- UC4 Yards and Centimeters Test Cases ---

    @Test
    public void testEquality_YardToYard_SameValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard1.equals(yard2), "1.0 Yard should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(2.0, LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2), "1.0 Yard should not equal 2.0 Yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet), "1.0 Yard should equal 3.0 Feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard), "3.0 Feet should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches), "1.0 Yard should equal 36.0 Inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length inches = new Length(36.0, LengthUnit.INCHES);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(inches.equals(yard), "36.0 Inches should equal 1.0 Yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(2.0, LengthUnit.FEET);
        assertFalse(yard.equals(feet), "1.0 Yard should not equal 2.0 Feet");
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(cm.equals(inches), "1.0 Centimeter should equal 0.393701 Inches");
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertFalse(cm.equals(feet), "1.0 Centimeter should not equal 1.0 Foot");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches),
                "Transitive property: yard equals feet, feet equals inches, yard equals inches");
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }

    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
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
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm));
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        assertFalse(cm.equals(null));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inches = new Length(72.0, LengthUnit.INCHES);
        assertTrue(yard.equals(feet) && feet.equals(inches));
    }

    // --- Specific UC4 tests matching UI screenshot ---

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701, LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(cm.equals(feet));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(1.0, LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        // Reflexive
        assertTrue(yard.equals(yard));

        // Symmetric
        assertTrue(yard.equals(feet) && feet.equals(yard));

        // Transitive
        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(2.0, LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.YARDS,
                3.0, LengthUnit.FEET));
    }

    // --- UC5 Unit Conversion Test Cases ---

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0, QuantityMeasurementApp.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0, QuantityMeasurementApp.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET), 1e-6);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0, QuantityMeasurementApp.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(2.0, QuantityMeasurementApp.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS),
                1e-6);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(1.0, QuantityMeasurementApp.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_FeatToYard() {
        assertEquals(2.0, QuantityMeasurementApp.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS), 1e-6);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double originalValue = 10.0;
        double feetToInches = QuantityMeasurementApp.convert(originalValue, LengthUnit.FEET,
                LengthUnit.INCHES);
        double roundTrip = QuantityMeasurementApp.convert(feetToInches, LengthUnit.INCHES,
                LengthUnit.FEET);
        assertEquals(originalValue, roundTrip, 1e-6);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(0.0, QuantityMeasurementApp.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(-12.0, QuantityMeasurementApp.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, null, LengthUnit.FEET);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, LengthUnit.FEET, null);
        });
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(Double.NEGATIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES);
        });
    }

    @Test
    public void testConversion_PrecisionTolerance() {
        double result = QuantityMeasurementApp.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        // Asserting that it is approximately 0.393701 within standard epsilon delta
        // (1e-6)
        assertEquals(0.393701, result, 1e-6);
    }

    // --- UC6 & UC7 Addition Test Cases ---

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2);
        assertEquals(new Length(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Length inch1 = new Length(6.0, LengthUnit.INCHES);
        Length inch2 = new Length(6.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(inch1, inch2);
        assertEquals(new Length(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches);
        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(inches, feet);
        assertEquals(new Length(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(yard, feet);
        assertEquals(new Length(2.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(cm, inch);
        // 2.54 cm + 1.0 inch (in target unit CENTIMETERS)
        // 1.0 inch = 2.54 cm, so total is 5.08 cm
        assertEquals(new Length(5.08, LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_Commutativity() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        Length feetPlusInches = QuantityMeasurementApp.add(feet, inches);
        Length inchesPlusFeet = QuantityMeasurementApp.add(inches, feet);

        // They are equal in length, although their target units differ (Feet vs
        // Inches).
        // Let's assert they are equal as measurements:
        assertTrue(feetPlusInches.equals(inchesPlusFeet));
    }

    @Test
    public void testAddition_WithZero() {
        Length feet = new Length(5.0, LengthUnit.FEET);
        Length inches = new Length(0.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches);
        assertEquals(new Length(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NegativeValues() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(-2.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2);
        assertEquals(new Length(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NullSecondOperand() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(feet, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(null, feet);
        });
    }

    @Test
    public void testAddition_LargeValues() {
        Length feet1 = new Length(1000000.0, LengthUnit.FEET);
        Length feet2 = new Length(1000000.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2);
        assertEquals(new Length(2000000.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SmallValues() {
        Length feet1 = new Length(0.001, LengthUnit.FEET);
        Length feet2 = new Length(0.002, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2);
        assertEquals(new Length(0.003, LengthUnit.FEET), result);
    }

    // --- UC7 Explicit Addition Test Cases ---

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, LengthUnit.FEET);
        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, LengthUnit.INCHES);
        assertEquals(new Length(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, LengthUnit.YARDS);
        // 2.0 feet = 0.66667 yards
        assertEquals(new Length(2.0 / 3.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(cm, inch, LengthUnit.CENTIMETERS);
        // 2.54 cm + 1.0 inch (in CENTIMETERS)
        // 1 inch = 2.54 cm, total is 5.08 cm
        assertEquals(new Length(5.08, LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(yard, feet, LengthUnit.YARDS);
        assertEquals(new Length(2.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length inches = new Length(36.0, LengthUnit.INCHES);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.add(inches, yard, LengthUnit.YARDS);
        assertEquals(new Length(2.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        
        Length result1 = QuantityMeasurementApp.add(yard, feet, LengthUnit.FEET);
        Length result2 = QuantityMeasurementApp.add(feet, yard, LengthUnit.FEET);
        
        assertEquals(result1, result2);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        Length feet = new Length(5.0, LengthUnit.FEET);
        Length inches = new Length(0.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(feet, inches, LengthUnit.YARDS);
        assertEquals(new Length(5.0 / 3.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(-2.0, LengthUnit.FEET);
        Length result = QuantityMeasurementApp.add(feet1, feet2, LengthUnit.INCHES);
        assertEquals(new Length(36.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(feet, inches, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(feet, null, LengthUnit.FEET);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.add(null, inches, LengthUnit.FEET);
        });
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length yard1 = new Length(100.0, LengthUnit.YARDS);
        Length yard2 = new Length(100.0, LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.add(yard1, yard2, LengthUnit.INCHES);
        assertEquals(new Length(7200.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length inch1 = new Length(36.0, LengthUnit.INCHES);
        Length inch2 = new Length(36.0, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(inch1, inch2, LengthUnit.YARDS);
        assertEquals(new Length(2.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length yards = new Length(1.0, LengthUnit.YARDS);
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);

        // Sum of all: 1 ft + 1 ft + 3 ft + 1 ft = 6 ft
        Length sum1 = QuantityMeasurementApp.add(feet, inches, LengthUnit.FEET); // 2 ft
        Length sum2 = QuantityMeasurementApp.add(sum1, yards, LengthUnit.FEET);  // 5 ft
        Length sum3 = QuantityMeasurementApp.add(sum2, cm, LengthUnit.FEET);     // 6 ft

        assertEquals(new Length(6.0, LengthUnit.FEET), sum3);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        Length cm = new Length(100.0, LengthUnit.CENTIMETERS);
        Length inch = new Length(39.3701, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(cm, inch, LengthUnit.FEET);
        double expectedFeet = (100.0 * (0.393701 / 12.0)) + (39.3701 / 12.0);
        assertEquals(new Length(expectedFeet, LengthUnit.FEET), result);
    }

    // --- UC8 Standalone LengthUnit and Delegated Conversion Test Cases ---

    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor());
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), 1e-6);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor());
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.393701 / 12.0, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0));
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0));
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 1e-4);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {
        assertEquals(2.0, LengthUnit.FEET.convertFromBaseUnit(2.0));
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0));
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0));
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 1e-4);
    }

    // --- UC9 Weight Support Test Cases ---

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(kg1.equals(kg2));
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertFalse(kg1.equals(kg2));
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(g.equals(kg));
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertFalse(kg.equals(feet));
    }

    @Test
    public void testEquality_NullComparisonWeight() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertFalse(kg.equals(null));
    }

    @Test
    public void testEquality_SameReferenceWeight() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(kg.equals(kg));
    }

    @Test
    public void testEquality_NullUnitWeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityWeight(1.0, null);
        });
    }

    @Test
    public void testEquality_TransitivePropertyWeight() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);
        assertTrue(kg.equals(g) && g.equals(lb) && kg.equals(lb));
    }

    @Test
    public void testEquality_ZeroValueWeight() {
        QuantityWeight kg = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(0.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testEquality_NegativeWeight() {
        QuantityWeight kg = new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(-1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testEquality_LargeWeightValue() {
        QuantityWeight kg = new QuantityWeight(1000.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testEquality_SmallWeightValue() {
        QuantityWeight kg = new QuantityWeight(0.001, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testConversion_PoundToKilogram() {
        QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight kg = lb.convertTo(WeightUnit.KILOGRAM);
        assertEquals(1.0, kg.getValue(), 1e-4);
    }

    @Test
    public void testConversion_KilogramToPound() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight lb = kg.convertTo(WeightUnit.POUND);
        assertEquals(2.20462, lb.getValue(), 1e-4);
    }

    @Test
    public void testConversion_SameUnitWeight() {
        QuantityWeight kg = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        assertEquals(kg, kg.convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_ZeroValueWeight() {
        QuantityWeight kg = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(0.0, WeightUnit.GRAM), kg.convertTo(WeightUnit.GRAM));
    }

    @Test
    public void testConversion_NegativeValueWeight() {
        QuantityWeight kg = new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(-1000.0, WeightUnit.GRAM), kg.convertTo(WeightUnit.GRAM));
    }

    @Test
    public void testConversion_RoundTripWeight() {
        QuantityWeight kg = new QuantityWeight(1.5, WeightUnit.KILOGRAM);
        QuantityWeight roundTrip = kg.convertTo(WeightUnit.GRAM).convertTo(WeightUnit.KILOGRAM);
        assertEquals(kg.getValue(), roundTrip.getValue(), 1e-6);
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {
        QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), kg1.add(kg2));
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2.0, WeightUnit.KILOGRAM), kg.add(g));
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {
        QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(4.40924, lb.add(kg).getValue(), 1e-4);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), kg.add(g, WeightUnit.GRAM));
    }

    @Test
    public void testAddition_CommutativityWeight() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight sum1 = kg.add(g);
        QuantityWeight sum2 = g.add(kg);
        assertTrue(sum1.equals(sum2));
    }

    @Test
    public void testAddition_WithZeroWeight() {
        QuantityWeight kg = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(0.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(5.0, WeightUnit.KILOGRAM), kg.add(g));
    }

    @Test
    public void testAddition_NegativeValuesWeight() {
        QuantityWeight kg = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(-2000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), kg.add(g));
    }

    @Test
    public void testAddition_LargeValuesWeight() {
        QuantityWeight kg1 = new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(2e6, WeightUnit.KILOGRAM), kg1.add(kg2));
    }

    // --- UC10 Generic Quantity and Scalability Test Cases ---

    private enum DummyVolumeUnit implements IMeasurable {
        LITER(1.0),
        MILLILITER(0.001),
        GALLON(3.78541);

        private final double factor;
        DummyVolumeUnit(double factor) { this.factor = factor; }
        public double getConversionFactor() { return factor; }
        public double convertToBaseUnit(double value) { return value * factor; }
        public double convertFromBaseUnit(double baseValue) { return baseValue / factor; }
    }

    @Test
    public void testIMeasurableInterface_LengthUnitImplementation() {
        IMeasurable feet = LengthUnit.FEET;
        assertEquals(1.0, feet.getConversionFactor());
        assertEquals(5.0, feet.convertToBaseUnit(5.0));
    }

    @Test
    public void testIMeasurableInterface_WeightUnitImplementation() {
        IMeasurable kg = WeightUnit.KILOGRAM;
        assertEquals(1.0, kg.getConversionFactor());
        assertEquals(10.0, kg.convertToBaseUnit(10.0));
    }

    @Test
    public void testGenericQuantity_LengthOperations_Equality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(q1.equals(q2));
    }

    @Test
    public void testGenericQuantity_WeightOperations_Equality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(q1.equals(q2));
    }

    @Test
    public void testGenericQuantity_LengthOperations_Conversion() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals(12.0, q.convertTo(LengthUnit.INCHES).getValue(), 1e-6);
    }

    @Test
    public void testGenericQuantity_WeightOperations_Conversion() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertEquals(1000.0, q.convertTo(WeightUnit.GRAM).getValue(), 1e-6);
    }

    @Test
    public void testGenericQuantity_LengthOperations_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> sum = q1.add(q2, LengthUnit.FEET);
        assertEquals(2.0, sum.getValue(), 1e-6);
    }

    @Test
    public void testGenericQuantity_WeightOperations_Addition() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> sum = q1.add(q2, WeightUnit.KILOGRAM);
        assertEquals(2.0, sum.getValue(), 1e-6);
    }

    @Test
    public void testCrossCategoryPrevention_LengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(length.equals(weight));
    }

    @Test
    public void testGenericQuantity_ConstructorValidation_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<LengthUnit>(1.0, null);
        });
    }

    @Test
    public void testGenericQuantity_ConstructorValidation_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<LengthUnit>(Double.NaN, LengthUnit.FEET);
        });
    }

    @Test
    public void testHashCode_GenericQuantity_Consistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    public void testEquals_GenericQuantity_ContractPreservation() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q3 = new Quantity<>(1.0 / 3.0, LengthUnit.YARDS);

        // Reflexive
        assertTrue(q1.equals(q1));

        // Symmetric
        assertTrue(q1.equals(q2) && q2.equals(q1));

        // Transitive
        assertTrue(q1.equals(q2) && q2.equals(q3) && q1.equals(q3));
    }

    // ============================================================
    // UC-11: Volume Measurement Tests (VolumeUnit enum)
    // ============================================================

    // --- VolumeUnit Enum Constant Verification ---

    @Test
    public void testVolumeUnitEnum_LitreConstant() {
        assertEquals(1.0, VolumeUnit.LITRE.getConversionFactor(), 1e-9,
                "LITRE conversion factor should be 1.0 (base unit)");
    }

    @Test
    public void testVolumeUnitEnum_MillilitreConstant() {
        assertEquals(0.001, VolumeUnit.MILLILITRE.getConversionFactor(), 1e-9,
                "MILLILITRE conversion factor should be 0.001");
    }

    @Test
    public void testVolumeUnitEnum_GallonConstant() {
        assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor(), 1e-5,
                "GALLON conversion factor should be 3.78541");
    }

    @Test
    public void testConvertToBaseUnit_LitreToLitre() {
        assertEquals(5.0, VolumeUnit.LITRE.convertToBaseUnit(5.0), 1e-9,
                "LITRE.convertToBaseUnit should return same value");
    }

    @Test
    public void testConvertToBaseUnit_MillilitreToLitre() {
        assertEquals(1.0, VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0), 1e-9,
                "1000 mL should convert to 1 L in base");
    }

    @Test
    public void testConvertToBaseUnit_GallonToLitre() {
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), 1e-5,
                "1 Gallon should convert to 3.78541 L in base");
    }

    @Test
    public void testConvertFromBaseUnit_LitreToLitre() {
        assertEquals(2.0, VolumeUnit.LITRE.convertFromBaseUnit(2.0), 1e-9,
                "2 L base should convert to 2 L");
    }

    @Test
    public void testConvertFromBaseUnit_LitreToMillilitre() {
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), 1e-9,
                "1 L base should convert to 1000 mL");
    }

    @Test
    public void testConvertFromBaseUnit_LitreToGallon() {
        assertEquals(1.0, VolumeUnit.GALLON.convertFromBaseUnit(3.78541), 1e-4,
                "3.78541 L base should convert to ~1 Gallon");
    }

    // --- Volume Equality Tests ---

    @Test
    public void testEquality_Volume_LitreToLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1 L should equal 1 L");
    }

    @Test
    public void testEquality_Volume_LitreToMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "1 L should equal 1000 mL");
    }

    @Test
    public void testEquality_Volume_GallonToLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1 Gallon should equal 3.78541 L");
    }

    @Test
    public void testEquality_Volume_NotEqual() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertFalse(v1.equals(v2), "1 L should not equal 2 L");
    }

    @Test
    public void testEquality_Volume_ZeroValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "0 L should equal 0 mL");
    }

    @Test
    public void testEquality_Volume_NegativeVolume() {
        Quantity<VolumeUnit> v1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "-1 L should equal -1000 mL");
    }

    @Test
    public void testEquality_Volume_LargeValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1,000,000 mL should equal 1000 L");
    }

    @Test
    public void testEquality_Volume_SmallValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "0.001 L should equal 1 mL");
    }

    // --- Volume Conversion Tests ---

    @Test
    public void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
        assertEquals(1000.0, result.getValue(), 1e-9, "1 L should convert to 1000 mL");
    }

    @Test
    public void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.LITRE);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
        assertEquals(1.0, result.getValue(), 1e-9, "1000 mL should convert to 1 L");
    }

    @Test
    public void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.LITRE);
        assertEquals(3.78541, result.getValue(), 1e-4, "1 Gallon should convert to ~3.78541 L");
    }

    @Test
    public void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> v = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.GALLON);
        assertEquals(1.0, result.getValue(), 1e-4, "3.78541 L should convert to ~1 Gallon");
    }

    @Test
    public void testConversion_MillilitreToGallon() {
        Quantity<VolumeUnit> v = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.GALLON);
        assertEquals(0.264172, result.getValue(), 1e-4, "1000 mL should convert to ~0.264172 Gallon");
    }

    @Test
    public void testConversion_Volume_SameUnit() {
        Quantity<VolumeUnit> v = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.LITRE);
        assertEquals(5.0, result.getValue(), 1e-9, "Converting to same unit returns unchanged value");
    }

    @Test
    public void testConversion_Volume_ZeroValue() {
        Quantity<VolumeUnit> v = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(0.0, result.getValue(), 1e-9, "0 L converts to 0 mL");
    }

    @Test
    public void testConversion_Volume_NegativeValue() {
        Quantity<VolumeUnit> v = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(-1000.0, result.getValue(), 1e-9, "-1 L converts to -1000 mL");
    }

    @Test
    public void testConversion_Volume_RoundTrip() {
        Quantity<VolumeUnit> original = new Quantity<>(1.5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = original.convertTo(VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE);
        assertEquals(1.5, result.getValue(), 1e-4, "Round-trip conversion should preserve value");
    }

    // --- Volume Addition Tests ---

    @Test
    public void testAddition_Volume_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(3.0, result.getValue(), 1e-9, "1 L + 2 L = 3 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void testAddition_Volume_SameUnit_MillilitrePlusMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(1000.0, result.getValue(), 1e-9, "500 mL + 500 mL = 1000 mL");
    }

    @Test
    public void testAddition_Volume_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2.0, result.getValue(), 1e-9, "1 L + 1000 mL = 2 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void testAddition_Volume_CrossUnit_MillilitrePlusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2000.0, result.getValue(), 1e-9, "1000 mL + 1 L = 2000 mL");
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void testAddition_Volume_CrossUnit_GallonPlusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2.0, result.getValue(), 1e-4, "1 Gallon + 3.78541 L = ~2 Gallon");
    }

    @Test
    public void testAddition_Volume_ExplicitTargetUnit_Litre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.LITRE);
        assertEquals(2.0, result.getValue(), 1e-9, "1 L + 1000 mL = 2 L (target LITRE)");
    }

    @Test
    public void testAddition_Volume_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.MILLILITRE);
        assertEquals(2000.0, result.getValue(), 1e-9, "1 L + 1000 mL = 2000 mL (target MILLILITRE)");
    }

    @Test
    public void testAddition_Volume_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.GALLON);
        assertEquals(2.0, result.getValue(), 1e-4, "3.78541 L + 3.78541 L = ~2 Gallon (target GALLON)");
    }

    @Test
    public void testAddition_Volume_WithZero() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(5.0, result.getValue(), 1e-9, "5 L + 0 mL = 5 L (zero identity)");
    }

    @Test
    public void testAddition_Volume_NegativeValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(3.0, result.getValue(), 1e-9, "5 L + (-2000 mL) = 3 L");
    }

    @Test
    public void testAddition_Volume_LargeValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2e6, result.getValue(), 1e-3, "1M L + 1M L = 2M L");
    }

    @Test
    public void testAddition_Volume_SmallValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.002, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(0.003, result.getValue(), 1e-4, "0.001 L + 0.002 L = ~0.003 L");
    }

    // --- Backward Compatibility & Generic Scalability ---

    @Test
    public void testGenericQuantity_VolumeOperations_Consistency() {
        // VolumeUnit works identically to LengthUnit and WeightUnit
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(v.equals(v2), "Generic Quantity works for volume");
        Quantity<VolumeUnit> sum = v.add(v2);
        assertEquals(2.0, sum.getValue(), 1e-9, "Generic add works for volume");
        Quantity<VolumeUnit> converted = v.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(1000.0, converted.getValue(), 1e-9, "Generic convert works for volume");
    }

    @Test
    public void testScalability_VolumeIntegration() {
        // VolumeUnit integrates seamlessly with no special handling in Quantity<U>
        Quantity<VolumeUnit> g = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> l = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(g.equals(l));
        Quantity<VolumeUnit> sum = g.add(l, VolumeUnit.LITRE);
        assertEquals(2 * 3.78541, sum.getValue(), 1e-4, "Gallon + Litre sum in Litre");
    }
}




