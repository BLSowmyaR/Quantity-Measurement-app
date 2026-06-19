package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

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
}
