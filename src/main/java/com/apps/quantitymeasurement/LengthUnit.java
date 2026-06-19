package com.apps.quantitymeasurement;

/**
 * LengthUnit - Standalone enum representing length units with conversion responsibility.
 * Implements IMeasurable for generic quantity consolidation.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public enum LengthUnit implements IMeasurable {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.393701 / 12.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (FEET).
     */
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from the base unit (FEET) to this unit.
     */
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
