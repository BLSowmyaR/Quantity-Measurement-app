package com.apps.quantitymeasurement;

/**
 * IMeasurable - Defines standard contract for measurement unit conversions.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public interface IMeasurable {
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
    String name(); // Binds to Java's Enum.name() naturally
}
