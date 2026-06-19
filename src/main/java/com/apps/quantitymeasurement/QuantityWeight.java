package com.apps.quantitymeasurement;

/**
 * QuantityWeight - Represents a weight measurement with a value and a unit.
 * Compatibility wrapper extending generic Quantity.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public class QuantityWeight extends Quantity<WeightUnit> {

    public QuantityWeight(double value, WeightUnit unit) {
        super(value, unit);
    }

    /**
     * Converts this weight to a target unit, returning a new QuantityWeight object.
     */
    @Override
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        Quantity<WeightUnit> converted = super.convertTo(targetUnit);
        return new QuantityWeight(converted.getValue(), converted.getUnit());
    }

    /**
     * Adds two QuantityWeight measurements with implicit target unit (unit of this operand).
     */
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    /**
     * Adds this weight and another weight, returning the result in the specified target unit.
     */
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        Quantity<WeightUnit> sum = super.add(other, targetUnit);
        return new QuantityWeight(sum.getValue(), sum.getUnit());
    }
}
