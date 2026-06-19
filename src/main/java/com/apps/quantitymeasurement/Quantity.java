package com.apps.quantitymeasurement;

/**
 * Quantity - Generic class representing a measurement value with its unit.
 * Type parameter U is bound to IMeasurable.
 * Part of UC10 Generic Quantity Class refactoring.
 */
public class Quantity<U extends IMeasurable> {
    protected final double value;
    protected final U unit;

    public Quantity(double value, U unit) {
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

    public U getUnit() {
        return unit;
    }

    /**
     * Converts this measurement to the target unit.
     */
    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(valueInBase);
        return new Quantity<>(convertedValue, targetUnit);
    }

    /**
     * Adds two measurements with the target unit being this operand's unit.
     */
    public Quantity<U> add(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        return add(other, this.unit);
    }

    /**
     * Adds two measurements and converts the result to targetUnit.
     */
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseSum = this.unit.convertToBaseUnit(this.value) + other.unit.convertToBaseUnit(other.value);
        double targetValue = targetUnit.convertFromBaseUnit(baseSum);
        return new Quantity<>(targetValue, targetUnit);
    }

    /**
     * Subtracts other from this measurement, with the target unit being this operand's unit.
     * Part of UC12: Subtraction and Division Operations.
     */
    public Quantity<U> subtract(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        return subtract(other, this.unit);
    }

    /**
     * Subtracts other from this measurement and converts the result to targetUnit.
     * Part of UC12: Subtraction and Division Operations.
     */
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseDiff = this.unit.convertToBaseUnit(this.value) - other.unit.convertToBaseUnit(other.value);
        double targetValue = targetUnit.convertFromBaseUnit(baseDiff);
        return new Quantity<>(targetValue, targetUnit);
    }

    /**
     * Divides this measurement by other, returning a dimensionless ratio (double).
     * Both quantities must be of the same measurement category.
     * Part of UC12: Subtraction and Division Operations.
     *
     * @throws ArithmeticException if the divisor is zero
     * @throws IllegalArgumentException if operand is null
     */
    public double divide(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        if (Math.abs(otherBase) < 1e-12) {
            throw new ArithmeticException("Division by zero: divisor quantity has zero base-unit value");
        }
        return thisBase / otherBase;
    }


    /**
     * Generic equality. Ensures measurements are equal by converting to their base unit.
     * Prevents cross-category comparisons (e.g. Length vs Weight) by checking unit classes.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Quantity)) {
            return false;
        }
        Quantity<?> other = (Quantity<?>) obj;
        
        // Ensure enums belong to the same category (e.g. LengthUnit vs WeightUnit)
        if (this.unit.getClass() != other.unit.getClass()) {
            return false;
        }
        
        double thisValueInBase = this.unit.convertToBaseUnit(this.value);
        // Cast is safe since we verified the unit class matches
        double otherValueInBase = ((IMeasurable) other.unit).convertToBaseUnit(other.value);
        
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
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
