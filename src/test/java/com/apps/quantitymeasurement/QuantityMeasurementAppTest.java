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

    // --- Additional tests matching UI screenshot ---

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
}
