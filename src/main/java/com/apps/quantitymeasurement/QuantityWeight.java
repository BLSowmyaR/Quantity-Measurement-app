package com.apps.quantitymeasurement;

/**
 * QuantityWeight - Represents a weight measurement with a value and a unit.
 * Part of UC9 Weight Support.
 */
public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
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

    public WeightUnit getUnit() {
        return unit;
    }

    /**
     * Converts this weight to a target unit, returning a new QuantityWeight object.
     */
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(valueInBase);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    /**
     * Adds two QuantityWeight measurements with implicit target unit (unit of this operand).
     */
    public QuantityWeight add(QuantityWeight other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        return add(other, this.unit);
    }

    /**
     * Adds this weight and another weight, returning the result in the specified target unit.
     */
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
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
        return new QuantityWeight(sumInTargetUnit, targetUnit);
    }

    /**
     * Compare two QuantityWeight objects. They are equal if they represent the same
     * weight after converting to the base unit (KILOGRAM).
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
        QuantityWeight other = (QuantityWeight) obj;
        
        double thisValueInBase = this.unit.convertToBaseUnit(this.value);
        double otherValueInBase = other.unit.convertToBaseUnit(other.value);
        
        // Use tolerance to handle pound-to-kilogram rounding differences
        return Math.abs(thisValueInBase - otherValueInBase) < 1e-4;
    }

    @Override
    public int hashCode() {
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        long roundedValue = Math.round(valueInBase * 1000.0);
        return Long.hashCode(roundedValue);
    }

    @Override
    public String toString() {
        return "QuantityWeight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
