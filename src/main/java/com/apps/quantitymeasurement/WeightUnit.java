package com.apps.quantitymeasurement;

/**
 * WeightUnit - Standalone enum representing weight units with conversion responsibility.
 * Implements IMeasurable for generic quantity consolidation.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public enum WeightUnit implements IMeasurable {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (KILOGRAM).
     */
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from the base unit (KILOGRAM) to this unit.
     */
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
