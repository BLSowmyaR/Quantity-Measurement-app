package com.apps.quantitymeasurement;

/**
 * WeightUnit - Standalone enum representing weight units with conversion responsibility.
 * Part of UC9 Weight Support.
 */
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (KILOGRAM).
     */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from the base unit (KILOGRAM) to this unit.
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
