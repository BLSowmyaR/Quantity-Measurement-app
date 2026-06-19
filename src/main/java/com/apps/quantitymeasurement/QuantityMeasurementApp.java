package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp - UC2: Inches measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet or inches in the Quantity Measurement Application.
 */
public class QuantityMeasurementApp {
    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        /**
         * Override equals() method to compare two Feet objects based on their value
         * 
         * <p>Important Checks:</p>
         * 1. Reference Check: If both references point to the same object, return true
         * 2. Null Check: If the compared object is null, return false
         * 3. Type Check: If the compared object is not of type Feet, return false
         * 4. Value Comparison: Use Double.compare() to compare the double values for equality
         * 
         * @param obj The object to compare with
         * @return true if both Feet objects have the same value, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            // 1. Reference Check
            if (this == obj) {
                return true;
            }
            // 2. Null Check
            if (obj == null) {
                return false;
            }
            // 3. Type Check
            if (getClass() != obj.getClass()) {
                return false;
            }
            // 4. Value Comparison
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inner class to represent Inches measurement
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        /**
         * Override equals() method to compare two Inches objects based on their value
         * 
         * <p>Important Checks:</p>
         * 1. Reference Check: If both references point to the same object, return true
         * 2. Null Check: If the compared object is null, return false
         * 3. Type Check: If the compared object is not of type Inches, return false
         * 4. Value Comparison: Use Double.compare() to compare the double values for equality
         * 
         * @param obj The object to compare with
         * @return true if both Inches objects have the same value, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            // 1. Reference Check
            if (this == obj) {
                return true;
            }
            // 2. Null Check
            if (obj == null) {
                return false;
            }
            // 3. Type Check
            if (getClass() != obj.getClass()) {
                return false;
            }
            // 4. Value Comparison
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Define a static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feet1.equals(feet2) + ")");
    }

    // Defining a static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + inches1.equals(inches2) + ")");
    }

    // Main method to demonstrate Inches equality check
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
