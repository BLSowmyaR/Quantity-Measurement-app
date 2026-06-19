package com.apps.quantitymeasurement;

/**
 * Length - Represents a length measurement with a value and a unit.
 * Part of UC8 Refactoring.
 */
public class Length {
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
     * Delegates conversion responsibility to LengthUnit.
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(valueInBase);
        return new Length(convertedValue, targetUnit);
    }

    /**
     * Adds two Length measurements with implicit target unit (unit of this operand).
     */
    public Length add(Length other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        return add(other, this.unit);
    }

    /**
     * Adds this length and another length, returning the result in the specified target unit.
     */
    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInBase1 = this.unit.convertToBaseUnit(this.value);
        double valueInBase2 = other.unit.convertToBaseUnit(other.value);
        double sumInBase = valueInBase1 + valueInBase2;
        double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumInBase);
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
        
        double thisValueInBase = this.unit.convertToBaseUnit(this.value);
        double otherValueInBase = other.unit.convertToBaseUnit(other.value);
        
        // Use a tolerance delta to handle imprecise centimeter to feet/inches conversions
        return Math.abs(thisValueInBase - otherValueInBase) < 1e-4;
    }

    @Override
    public int hashCode() {
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        // Round to 3 decimal places to keep hash code consistent for nearly equal values
        long roundedValue = Math.round(valueInBase * 1000.0);
        return Long.hashCode(roundedValue);
    }
}
