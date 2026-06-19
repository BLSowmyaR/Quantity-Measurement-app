package com.apps.quantitymeasurement;

/**
 * Length - Represents a length measurement with a value and a unit.
 * Part of UC3 Generic Quantity Class for DRY Principle.
 */
public class Length {
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0);

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
        
        return Double.compare(thisValueInFeet, otherValueInFeet) == 0;
    }

    @Override
    public int hashCode() {
        double valueInFeet = this.value * this.unit.getConversionFactor();
        return Double.hashCode(valueInFeet);
    }
}
