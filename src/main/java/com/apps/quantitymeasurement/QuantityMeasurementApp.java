package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC6 – Unified Quantity Measurement System
 *
 * This class introduces support for addition of measurements with conversion,
 * supporting implicit target unit specifications (UC6).
 *
 * @version 6.0
 * @author Development Team
 */
public class QuantityMeasurementApp {
    // Inner class to represent Feet measurement (retained for backward compatibility)
    public static class Feet {
        private final Length length;

        public Feet(double value) {
            this.length = new Length(value, Length.LengthUnit.FEET);
        }

        /**
         * Override equals() method to compare two Feet objects by delegating to Length.
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
            Feet other = (Feet) obj;
            return this.length.equals(other.length);
        }
    }

    // Inner class to represent Inches measurement (retained for backward compatibility)
    public static class Inches {
        private final Length length;

        public Inches(double value) {
            this.length = new Length(value, Length.LengthUnit.INCHES);
        }

        /**
         * Override equals() method to compare two Inches objects by delegating to Length.
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
            Inches other = (Inches) obj;
            return this.length.equals(other.length);
        }
    }

    // Create a generic method to demonstrate Length equality check
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean isEqual = length1.equals(length2);
        System.out.println("Input: Quantity(" + length1.getValue() + ", " + length1.getUnit() + ") and Quantity(" + length2.getValue() + ", " + length2.getUnit() + ")");
        System.out.println("Output: Equal (" + isEqual + ")");
        System.out.println();
        return isEqual;
    }

    // Create a static method to take in method parameters and demonstrate
    // equality check
    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1, double value2, Length.LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        return demonstrateLengthEquality(length1, length2);
    }

    /**
     * Public static API to convert values from one unit to another.
     * Part of UC5 Unit Conversion.
     */
    public static double convert(double value, Length.LengthUnit source, Length.LengthUnit target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double valueInFeet = value * source.getConversionFactor();
        return valueInFeet / target.getConversionFactor();
    }

    /**
     * Demonstrates conversion taking raw value and source/target units.
     */
    public static double demonstrateLengthConversion(double value, Length.LengthUnit source, Length.LengthUnit target) {
        double result = convert(value, source, target);
        System.out.println("Input: convert(" + value + ", " + source + ", " + target + ") -> Output: " + result);
        return result;
    }

    /**
     * Demonstrates conversion taking a Length object and target unit.
     */
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit targetUnit) {
        if (length == null) {
            throw new IllegalArgumentException("Length object cannot be null");
        }
        Length result = length.convertTo(targetUnit);
        System.out.println("Input: convert(Quantity(" + length.getValue() + ", " + length.getUnit() + "), " + targetUnit + ") -> Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Adds two Lengths with implicit target unit (first operand's unit).
     * Part of UC6 Arithmetic Operations.
     */
    public static Length add(Length length1, Length length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        return length1.add(length2);
    }

    /**
     * Demonstrates addition with implicit target unit (UC6).
     */
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Length result = add(length1, length2);
        System.out.println("Input: add(Quantity(" + length1.getValue() + ", " + length1.getUnit() + "), Quantity(" + length2.getValue() + ", " + length2.getUnit() + "))");
        System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")");
        System.out.println();
        return result;
    }

    // Main method to demonstrate extended unit support, conversions, and additions
    public static void main(String[] args) {
        System.out.println("=== Comparisons ===");
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                    12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                    36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                                    39.3701, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                                    1.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                                    1.0, Length.LengthUnit.FEET);

        System.out.println("=== Conversions ===");
        demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        demonstrateLengthConversion(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        Length lengthInYards = new Length(3.0, Length.LengthUnit.YARDS);
        demonstrateLengthConversion(lengthInYards, Length.LengthUnit.FEET);

        System.out.println("=== Additions (Implicit Target Unit - UC6) ===");
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.FEET), new Length(2.0, Length.LengthUnit.FEET));
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(12.0, Length.LengthUnit.INCHES), new Length(1.0, Length.LengthUnit.FEET));
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.YARDS), new Length(3.0, Length.LengthUnit.FEET));
        demonstrateLengthAddition(new Length(36.0, Length.LengthUnit.INCHES), new Length(1.0, Length.LengthUnit.YARDS));
        demonstrateLengthAddition(new Length(2.54, Length.LengthUnit.CENTIMETERS), new Length(1.0, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(5.0, Length.LengthUnit.FEET), new Length(0.0, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(5.0, Length.LengthUnit.FEET), new Length(-2.0, Length.LengthUnit.FEET));
    }
}
