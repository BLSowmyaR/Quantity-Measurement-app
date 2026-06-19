package com.apps.quantitymeasurement;

/**
 * Data Transfer Object representing a measurement operation request and response.
 * Part of UC-14: Service Layer Architecture.
 *
 * @param <U> The type of measurement unit (e.g., LengthUnit, WeightUnit, VolumeUnit)
 */
public class QuantityEntity<U extends IMeasurable> {
    private double value1;
    private U unit1;
    private double value2;
    private U unit2;
    private String operation;
    
    // Result fields
    private double resultValue;
    private U resultUnit;
    private boolean isEquality;
    
    // Error handling
    private boolean hasError;
    private String errorMessage;

    // Constructors
    public QuantityEntity() {}

    /**
     * Constructor for single-operand operations (e.g., Conversion)
     */
    public QuantityEntity(double value1, U unit1, String operation, U targetUnit) {
        this.value1 = value1;
        this.unit1 = unit1;
        this.operation = operation;
        this.resultUnit = targetUnit;
    }

    /**
     * Constructor for binary-operand operations (e.g., Addition, Subtraction, Equality, Division)
     */
    public QuantityEntity(double value1, U unit1, double value2, U unit2, String operation) {
        this.value1 = value1;
        this.unit1 = unit1;
        this.value2 = value2;
        this.unit2 = unit2;
        this.operation = operation;
    }

    /**
     * Constructor for error states
     */
    public QuantityEntity(boolean hasError, String errorMessage) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
    }

    // Getters and Setters
    public double getValue1() { return value1; }
    public void setValue1(double value1) { this.value1 = value1; }

    public U getUnit1() { return unit1; }
    public void setUnit1(U unit1) { this.unit1 = unit1; }

    public double getValue2() { return value2; }
    public void setValue2(double value2) { this.value2 = value2; }

    public U getUnit2() { return unit2; }
    public void setUnit2(U unit2) { this.unit2 = unit2; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public double getResultValue() { return resultValue; }
    public void setResultValue(double resultValue) { this.resultValue = resultValue; }

    public U getResultUnit() { return resultUnit; }
    public void setResultUnit(U resultUnit) { this.resultUnit = resultUnit; }

    public boolean isEquality() { return isEquality; }
    public void setEquality(boolean equality) { isEquality = equality; }

    public boolean isHasError() { return hasError; }
    public void setHasError(boolean hasError) { this.hasError = hasError; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    @Override
    public String toString() {
        if (hasError) {
            return "Error: " + errorMessage;
        }
        
        switch (operation.toUpperCase()) {
            case "EQUALITY":
                return "Compare: Quantity(" + value1 + ", " + unit1 + ") and Quantity(" + value2 + ", " + unit2 + ") => " + (isEquality ? "Equal" : "Not Equal");
            case "CONVERSION":
                return "Convert: Quantity(" + value1 + ", " + unit1 + ") to " + resultUnit + " => Quantity(" + resultValue + ", " + resultUnit + ")";
            case "ADDITION":
                return "Add: Quantity(" + value1 + ", " + unit1 + ") + Quantity(" + value2 + ", " + unit2 + ") => Quantity(" + resultValue + ", " + resultUnit + ")";
            case "SUBTRACTION":
                return "Subtract: Quantity(" + value1 + ", " + unit1 + ") - Quantity(" + value2 + ", " + unit2 + ") => Quantity(" + resultValue + ", " + resultUnit + ")";
            case "DIVISION":
                return "Divide: Quantity(" + value1 + ", " + unit1 + ") / Quantity(" + value2 + ", " + unit2 + ") => " + resultValue;
            default:
                return "Operation: " + operation;
        }
    }
}
