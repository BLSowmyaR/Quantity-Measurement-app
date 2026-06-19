package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp – Unified Generic Quantity Measurement System
 *
 * Extended in UC13 to introduce DRY ArithmeticOperation enum refactoring.
 *
 * @version 13.0
 * @author Development Team
 */
public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement (retained for backward compatibility)
    public static class Feet {
        private final Length length;

        public Feet(double value) {
            this.length = new Length(value, LengthUnit.FEET);
        }

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
            Feet other = (Feet) obj;
            return this.length.equals(other.length);
        }
    }

    // Inner class to represent Inches measurement (retained for backward compatibility)
    public static class Inches {
        private final Length length;

        public Inches(double value) {
            this.length = new Length(value, LengthUnit.INCHES);
        }

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
            Inches other = (Inches) obj;
            return this.length.equals(other.length);
        }
    }

    // --- UC10 Generic Demonstration Methods ---

    /**
     * Demonstrates equality check on any two Quantity objects.
     */
    public static boolean demonstrateEquality(Quantity<?> q1, Quantity<?> q2) {
        boolean isEqual = q1.equals(q2);
        System.out.println("Input: Quantity(" + q1.getValue() + ", " + q1.getUnit() + ") and Quantity("
                + q2.getValue() + ", " + q2.getUnit() + ")");
        System.out.println("Output: Equal (" + isEqual + ")");
        System.out.println();
        return isEqual;
    }

    /**
     * Demonstrates unit conversion for any Quantity object.
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit) {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity object cannot be null");
        }
        Quantity<U> result = quantity.convertTo(targetUnit);
        System.out.println("Input: convert(Quantity(" + quantity.getValue() + ", " + quantity.getUnit() + "), " + targetUnit
                + ") -> Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Demonstrates addition with implicit target unit.
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2) {
        Quantity<U> result = q1.add(q2);
        System.out.println("Input: add(Quantity(" + formatValue(q1.getValue()) + ", " + q1.getUnit() + "), Quantity(" + formatValue(q2.getValue()) + ", " + q2.getUnit() + "))");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Demonstrates subtraction with implicit target unit.
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2) {
        Quantity<U> result = q1.subtract(q2);
        System.out.println("Input: subtract(Quantity(" + formatValue(q1.getValue()) + ", " + q1.getUnit() + "), Quantity(" + formatValue(q2.getValue()) + ", " + q2.getUnit() + "))");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Demonstrates subtraction with explicitly specified target unit.
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        Quantity<U> result = q1.subtract(q2, targetUnit);
        System.out.println("Input: subtract(Quantity(" + formatValue(q1.getValue()) + ", " + q1.getUnit() + "), Quantity(" + formatValue(q2.getValue()) + ", " + q2.getUnit() + "), " + targetUnit + ")");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Demonstrates division returning a dimensionless ratio.
     */
    public static <U extends IMeasurable> double demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {
        double result = q1.divide(q2);
        System.out.println("Input: divide(Quantity(" + formatValue(q1.getValue()) + ", " + q1.getUnit() + "), Quantity(" + formatValue(q2.getValue()) + ", " + q2.getUnit() + "))");
        System.out.println("Output: " + result);
        return result;
    }

    /**
     * Demonstrates addition with explicitly specified target unit.
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        Quantity<U> result = q1.add(q2, targetUnit);
        System.out.println("Input: add(Quantity(" + formatValue(q1.getValue()) + ", " + q1.getUnit() + "), " +
                           "Quantity(" + formatValue(q2.getValue()) + ", " + q2.getUnit() + "), " +
                           targetUnit + ")");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        System.out.println();
        return result;
    }

    // --- Legacy / Compatibility Methods (delegates to Generic system) ---

    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        return demonstrateEquality(length1, length2);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        return convertGeneric(value, source, target);
    }

    public static <U extends IMeasurable> double convertGeneric(double value, U source, U target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double valueInBase = source.convertToBaseUnit(value);
        return target.convertFromBaseUnit(valueInBase);
    }

    public static double demonstrateLengthConversion(double value, LengthUnit source, LengthUnit target) {
        double result = convert(value, source, target);
        System.out.println("Input: convert(" + value + ", " + source + ", " + target + ") -> Output: " + result);
        return result;
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit targetUnit) {
        Quantity<LengthUnit> result = demonstrateConversion(length, targetUnit);
        return new Length(result.getValue(), result.getUnit());
    }

    public static Length add(Length length1, Length length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Quantity<LengthUnit> result = demonstrateAddition(length1, length2);
        return new Length(result.getValue(), result.getUnit());
    }

    public static Length add(Length length1, Length length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        return length1.add(length2, targetUnit);
    }

    public static double add(double value1, LengthUnit unit1, double value2, LengthUnit unit2, LengthUnit targetUnit) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        return add(length1, length2, targetUnit).getValue();
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        Quantity<LengthUnit> result = demonstrateAddition(length1, length2, targetUnit);
        return new Length(result.getValue(), result.getUnit());
    }

    // --- Private display formatting helper ---

    private static String formatValue(double value) {
        if (value == (long) value) {
            return String.valueOf(value);
        }
        double rounded2 = Math.round(value * 100.0) / 100.0;
        if (Math.abs(value - rounded2) < 1e-12) {
            return String.valueOf(rounded2);
        }
        double rounded3 = Math.round(value * 1000.0) / 1000.0;
        if (Math.abs(value - rounded3) < 1e-12) {
            return String.valueOf(rounded3);
        }
        return "~" + rounded3;
    }

    // Main method to demonstrate extended unit support, conversions, and additions
    public static void main(String[] args) {
        System.out.println("=== Comparisons ===");
        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, LengthUnit.CENTIMETERS, 39.3701, LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS, 1.0, LengthUnit.FEET);

        System.out.println("=== Conversions ===");
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);

        Length lengthInYards = new Length(3.0, LengthUnit.YARDS);
        demonstrateLengthConversion(lengthInYards, LengthUnit.FEET);

        System.out.println("=== Additions (Implicit Target Unit) ===");
        demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(2.0, LengthUnit.FEET));
        demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.FEET));
        demonstrateLengthAddition(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET));
        demonstrateLengthAddition(new Length(36.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.YARDS));
        demonstrateLengthAddition(new Length(2.54, LengthUnit.CENTIMETERS), new Length(1.0, LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(0.0, LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(-2.0, LengthUnit.FEET));

        System.out.println("=== Additions (Explicit Target Unit) ===");
        demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET);
        demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.INCHES);
        demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);
        demonstrateLengthAddition(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET), LengthUnit.YARDS);
        demonstrateLengthAddition(new Length(36.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.YARDS), LengthUnit.FEET);
        demonstrateLengthAddition(new Length(2.54, LengthUnit.CENTIMETERS), new Length(1.0, LengthUnit.INCHES), LengthUnit.CENTIMETERS);
        demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(0.0, LengthUnit.INCHES), LengthUnit.YARDS);
        demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(-2.0, LengthUnit.FEET), LengthUnit.INCHES);

        // UC9 and UC10 specific demonstrations
        System.out.println("=== UC10 Generic Quantity and Weight Demonstrations ===");
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        demonstrateEquality(w1, w2);

        demonstrateConversion(w1, WeightUnit.GRAM);
        demonstrateConversion(new Quantity<>(2.20462, WeightUnit.POUND), WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w3 = new Quantity<>(500.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w4 = new Quantity<>(0.5, WeightUnit.KILOGRAM);
        demonstrateAddition(w3, w4);
        demonstrateAddition(w1, w3, WeightUnit.GRAM);

        // UC11 Volume Demonstrations
        System.out.println("=== UC11 Volume Equality ===");
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        demonstrateEquality(v1, v2);

        Quantity<VolumeUnit> v3 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v4 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        demonstrateEquality(v3, v4);

        System.out.println("=== UC11 Volume Conversions ===");
        demonstrateConversion(v1, VolumeUnit.MILLILITRE);
        demonstrateConversion(v2, VolumeUnit.LITRE);
        demonstrateConversion(v3, VolumeUnit.LITRE);
        demonstrateConversion(new Quantity<>(3.78541, VolumeUnit.LITRE), VolumeUnit.GALLON);
        demonstrateConversion(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), VolumeUnit.GALLON);

        System.out.println("=== UC11 Volume Additions ===");
        demonstrateAddition(v1, v2);
        demonstrateAddition(v1, v2, VolumeUnit.MILLILITRE);
        demonstrateAddition(v3, v4, VolumeUnit.GALLON);
        demonstrateAddition(new Quantity<>(500.0, VolumeUnit.MILLILITRE),
                            new Quantity<>(500.0, VolumeUnit.MILLILITRE));

        // UC12 Subtract and Divide Demonstrations
        System.out.println("=== UC12 Subtraction Demonstrations ===");
        demonstrateSubtraction(new Quantity<>(10.0, LengthUnit.FEET), new Quantity<>(5.0, LengthUnit.FEET));
        demonstrateSubtraction(new Quantity<>(10.0, LengthUnit.FEET), new Quantity<>(6.0, LengthUnit.INCHES));
        demonstrateSubtraction(new Quantity<>(10.0, LengthUnit.FEET), new Quantity<>(6.0, LengthUnit.INCHES), LengthUnit.INCHES);
        demonstrateSubtraction(new Quantity<>(5.0, VolumeUnit.LITRE), new Quantity<>(2.0, VolumeUnit.LITRE), VolumeUnit.MILLILITRE);
        demonstrateSubtraction(new Quantity<>(1e6, WeightUnit.KILOGRAM), new Quantity<>(5e5, WeightUnit.KILOGRAM));

        System.out.println("=== UC12 Division Demonstrations ===");
        demonstrateDivision(new Quantity<>(10.0, LengthUnit.FEET), new Quantity<>(2.0, LengthUnit.FEET));
        demonstrateDivision(new Quantity<>(24.0, LengthUnit.INCHES), new Quantity<>(2.0, LengthUnit.FEET));
        demonstrateDivision(new Quantity<>(10.0, VolumeUnit.LITRE), new Quantity<>(5.0, VolumeUnit.LITRE));
        demonstrateDivision(new Quantity<>(2.0, WeightUnit.KILOGRAM), new Quantity<>(2000.0, WeightUnit.GRAM));
    }
}
