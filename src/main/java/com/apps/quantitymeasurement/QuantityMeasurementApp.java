package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp – Unified Quantity Measurement System
 *
 * Part of UC8 Refactoring.
 *
 * @version 8.0
 * @author Development Team
 */
public class QuantityMeasurementApp {
    // Inner class to represent Feet measurement (retained for backward
    // compatibility)
    public static class Feet {
        private final Length length;

        public Feet(double value) {
            this.length = new Length(value, LengthUnit.FEET);
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

    // Inner class to represent Inches measurement (retained for backward
    // compatibility)
    public static class Inches {
        private final Length length;

        public Inches(double value) {
            this.length = new Length(value, LengthUnit.INCHES);
        }

        /**
         * Override equals() method to compare two Inches objects by delegating to
         * Length.
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
        System.out.println("Input: Quantity(" + length1.getValue() + ", " + length1.getUnit() + ") and Quantity("
                + length2.getValue() + ", " + length2.getUnit() + ")");
        System.out.println("Output: Equal (" + isEqual + ")");
        System.out.println();
        return isEqual;
    }

    // Create a static method to take in method parameters and demonstrate
    // equality check
    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2,
            LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        return demonstrateLengthEquality(length1, length2);
    }

    /**
     * Public static API to convert values from one unit to another.
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double valueInBase = source.convertToBaseUnit(value);
        return target.convertFromBaseUnit(valueInBase);
    }

    /**
     * Demonstrates conversion taking raw value and source/target units.
     */
    public static double demonstrateLengthConversion(double value, LengthUnit source, LengthUnit target) {
        double result = convert(value, source, target);
        System.out.println("Input: convert(" + value + ", " + source + ", " + target + ") -> Output: " + result);
        return result;
    }

    /**
     * Demonstrates conversion taking a Length object and target unit.
     */
    public static Length demonstrateLengthConversion(Length length, LengthUnit targetUnit) {
        if (length == null) {
            throw new IllegalArgumentException("Length object cannot be null");
        }
        Length result = length.convertTo(targetUnit);
        System.out.println("Input: convert(Quantity(" + length.getValue() + ", " + length.getUnit() + "), " + targetUnit
                + ") -> Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Helper method to format double values for display.
     * Whole numbers and exact decimals are printed as is, whereas other numbers 
     * are formatted to up to 3 decimal places with a tilde prefix.
     */
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

    /**
     * Adds two Lengths with implicit target unit (first operand's unit).
     */
    public static Length add(Length length1, Length length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        return length1.add(length2);
    }

    /**
     * Demonstrates addition with implicit target unit.
     */
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Length result = add(length1, length2);
        System.out.println("Input: add(Quantity(" + formatValue(length1.getValue()) + ", " + length1.getUnit() + "), Quantity(" + formatValue(length2.getValue()) + ", " + length2.getUnit() + "))");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        return result;
    }

    /**
     * Adds two Lengths with explicitly specified target unit.
     */
    public static Length add(Length length1, Length length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        return length1.add(length2, targetUnit);
    }

    /**
     * Overloaded static API to add raw length values and return the result value.
     */
    public static double add(double value1, LengthUnit unit1, double value2, LengthUnit unit2, LengthUnit targetUnit) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        return add(length1, length2, targetUnit).getValue();
    }

    /**
     * Demonstrates addition with explicitly specified target unit.
     */
    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        Length result = add(length1, length2, targetUnit);
        System.out.println("Input: add(Quantity(" + formatValue(length1.getValue()) + ", " + length1.getUnit() + "), " +
                           "Quantity(" + formatValue(length2.getValue()) + ", " + length2.getUnit() + "), " +
                           targetUnit + ")");
        System.out.println("Output: Quantity(" + formatValue(result.getValue()) + ", " + result.getUnit() + ")");
        System.out.println();
        return result;
    }

    // Main method to demonstrate extended unit support, conversions, and additions
    public static void main(String[] args) {
        System.out.println("=== Comparisons ===");
        // Demonstrate Feet and Inches comparison
        demonstrateLengthComparison(1.0, LengthUnit.FEET,
                                    12.0, LengthUnit.INCHES);

        // Demonstrate Yards and Inches comparison
        demonstrateLengthComparison(1.0, LengthUnit.YARDS,
                                    36.0, LengthUnit.INCHES);

        // Demonstrate Centimeters and Inches comparison
        demonstrateLengthComparison(100.0, LengthUnit.CENTIMETERS,
                                    39.3701, LengthUnit.INCHES);

        // Demonstrate Feet and Yards comparison
        demonstrateLengthComparison(3.0, LengthUnit.FEET,
                                    1.0, LengthUnit.YARDS);

        // Demonstrate Centimeters and Feet comparison
        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS,
                                    1.0, LengthUnit.FEET);

        System.out.println("=== Conversions ===");
        // Demonstrate Conversions
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);

        // Overloaded instance method demonstration
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
    }
}
