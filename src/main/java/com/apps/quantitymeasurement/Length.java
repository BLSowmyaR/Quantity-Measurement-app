package com.apps.quantitymeasurement;

/**
 * Length - Represents a length measurement with a value and a unit.
 * Part of UC3 Generic Quantity Class for DRY Principle.
 */
public class Length {
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Converts this length to a target unit, returning a new Length object.
     * Part of UC5 Unit Conversion.
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInFeet = this.value * this.unit.getConversionFactor();
        double convertedValue = valueInFeet / targetUnit.getConversionFactor();
        return new Length(convertedValue, targetUnit);
    }

    /**
     * Adds two Length measurements with implicit target unit (unit of this operand).
     * Part of UC6 Arithmetic Operations.
     */
    public Length add(Length other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        double valueInFeet1 = this.value * this.unit.getConversionFactor();
        double valueInFeet2 = other.value * other.unit.getConversionFactor();
        double sumInFeet = valueInFeet1 + valueInFeet2;
        double sumInTargetUnit = sumInFeet / this.unit.getConversionFactor();
        return new Length(sumInTargetUnit, this.unit);
    }

    /**
     * Adds this length and another length, returning the result in the specified target unit.
     * Part of UC7 Arithmetic Operations with Explicit Target Unit.
     */
    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInFeet1 = this.value * this.unit.getConversionFactor();
        double valueInFeet2 = other.value * other.unit.getConversionFactor();
        double sumInFeet = valueInFeet1 + valueInFeet2;
        double sumInTargetUnit = sumInFeet / targetUnit.getConversionFactor();
        return new Length(sumInTargetUnit, targetUnit);
    }

    /**
     * Compare two Length objects. They are equal if they represent the same
     * length after converting to the base unit (FEET).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Length other = (Length) obj;
        
        double thisValueInFeet = this.value * this.unit.getConversionFactor();
        double otherValueInFeet = other.value * other.unit.getConversionFactor();
        
        // Use a tolerance delta to handle imprecise centimeter to feet/inches conversions
        return Math.abs(thisValueInFeet - otherValueInFeet) < 1e-4;
    }

    @Override
    public int hashCode() {
        double valueInFeet = this.value * this.unit.getConversionFactor();
        // Round to 3 decimal places to keep hash code consistent for nearly equal values
        long roundedValue = Math.round(valueInFeet * 1000.0);
        return Long.hashCode(roundedValue);
    }
}
