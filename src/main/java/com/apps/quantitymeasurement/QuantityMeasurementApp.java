package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC3 – Unified Quantity Measurement System
 *
 * This class addresses the DRY (Don't Repeat Yourself) principle violations
 * present in the previous implementation where separate Feet and Inches classes
 * contained nearly identical code with:
 * - Identical constructor patterns
 * - Duplicate equals() method implementations
 * - Redundant validation logic
 *
 * UC3 introduces a unified approach to handle multiple units of length measurement
 * by consolidating common functionality and eliminating code duplication.
 * This refactoring promotes code reusability, maintainability, and scalability
 * for adding new measurement units without repeating boilerplate code.
 *
 * @author Development Team
 * @version 3.0
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
        String unit1 = length1.getUnit() == Length.LengthUnit.FEET ? "feet" : (length1.getValue() == 1.0 ? "inch" : "inches");
        String unit2 = length2.getUnit() == Length.LengthUnit.FEET ? "feet" : (length2.getValue() == 1.0 ? "inch" : "inches");
        System.out.println("Input: Quantity(" + length1.getValue() + ", \"" + unit1 + "\") and Quantity(" + length2.getValue() + ", \"" + unit2 + "\")");
        System.out.println("Output: Equal (" + isEqual + ")");
        return isEqual;
    }

    // Create a static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        demonstrateLengthEquality(feet1, feet2);
    }

    // Create a static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(inches1, inches2);
    }

    // Create a static method to demonstrate Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(feet, inches);
    }

    // Main method to demonstrate Feet and Inches equality checks and comparison checks
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
