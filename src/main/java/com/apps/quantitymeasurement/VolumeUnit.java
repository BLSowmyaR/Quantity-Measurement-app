package com.apps.quantitymeasurement;

/**
 * VolumeUnit - Standalone enum representing volume units with conversion responsibility.
 * Implements IMeasurable for generic quantity consolidation.
 * Base unit is LITRE.
 *
 * Conversion factors (relative to LITRE):
 *   LITRE      -> 1.0
 *   MILLILITRE -> 0.001  (1 mL = 0.001 L)
 *   GALLON     -> 3.78541 (1 US gallon = 3.78541 L)
 *
 * Part of UC11: Volume Measurement Support.
 */
public enum VolumeUnit implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (LITRE).
     */
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from the base unit (LITRE) to this unit.
     */
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
