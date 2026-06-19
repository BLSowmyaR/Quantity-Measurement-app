package com.apps.quantitymeasurement;

/**
 * Length - Represents a length measurement with a value and a unit.
 * Compatibility wrapper extending generic Quantity.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public class Length extends Quantity<LengthUnit> {

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    /**
     * Converts this length to a target unit, returning a new Length object.
     */
    @Override
    public Length convertTo(LengthUnit targetUnit) {
        Quantity<LengthUnit> converted = super.convertTo(targetUnit);
        return new Length(converted.getValue(), converted.getUnit());
    }

    /**
     * Adds two Length measurements with implicit target unit (unit of this operand).
     */
    public Length add(Length other) {
        return add(other, this.unit);
    }

    /**
     * Adds this length and another length, returning the result in the specified target unit.
     */
    public Length add(Length other, LengthUnit targetUnit) {
        Quantity<LengthUnit> sum = super.add(other, targetUnit);
        return new Length(sum.getValue(), sum.getUnit());
    }
}
