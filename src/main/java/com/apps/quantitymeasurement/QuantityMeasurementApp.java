package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC4 – Use Case 4: Extended Unit Support
 *
 * This class extends the Quantity Measurement Application (UC3) by introducing
 * support for additional length units: yards and centimeters.
 *
 * <p>UC4 enhances the previous implementation by:
 * <ul>
 *   <li>Adding yard (yd) as a supported unit of length measurement</li>
 *   <li>Adding centimeter (cm) as a supported unit of length measurement</li>
 *   <li>Enabling conversion between all supported length units including feet, inches, yards, and centimeters</li>
 *   <li>Maintaining backward compatibility with existing unit conversions from UC3</li>
 * </ul>
 *
 * <p><b>Supported Units:</b>
 * <ul>
 *   <li>Feet (ft)</li>
 *   <li>Inches (in)</li>
 *   <li>Yards (yd)</li>
 *   <li>Centimeters (cm)</li>
 * </ul>
 *
 * @version 4.0
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

    // Main method to demonstrate extended unit support
    public static void main(String[] args) {
        // Demonstrate Feet and Inches comparison
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                    12.0, Length.LengthUnit.INCHES);

        // Demonstrate Yards and Inches comparison
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                    36.0, Length.LengthUnit.INCHES);

        // Demonstrate Centimeters and Inches comparison
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                                    39.3701, Length.LengthUnit.INCHES);

        // Demonstrate Feet and Yards comparison
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                                    1.0, Length.LengthUnit.YARDS);

        // Demonstrate Centimeters and Feet comparison
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                                    1.0, Length.LengthUnit.FEET);
    }
}
