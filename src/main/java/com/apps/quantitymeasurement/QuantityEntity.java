package com.apps.quantitymeasurement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Data Transfer Object and JPA Entity for Quantity Measurement Operations.
 * Part of UC-14: Service Layer Architecture.
 *
 * @param <U> The type of measurement unit (e.g., LengthUnit, WeightUnit, VolumeUnit)
 */
@Entity
@Table(name = "quantity_measurement_entity")
public class QuantityEntity<U extends IMeasurable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value1;
    
    @Transient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private U unit1;
    private String unit1String; // For DB storage

    private double value2;
    
    @Transient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private U unit2;
    private String unit2String; // For DB storage

    private String operation;
    
    private double resultValue;
    
    @Transient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private U resultUnit;
    private String resultUnitString; // For DB storage
    
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
        setUnit1(unit1);
        this.operation = operation;
        setResultUnit(targetUnit);
    }

    /**
     * Constructor for binary-operand operations (e.g., Addition, Subtraction, Equality, Division)
     */
    public QuantityEntity(double value1, U unit1, double value2, U unit2, String operation) {
        this.value1 = value1;
        setUnit1(unit1);
        this.value2 = value2;
        setUnit2(unit2);
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
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getValue1() { return value1; }
    public void setValue1(double value1) { this.value1 = value1; }

    public U getUnit1() { return unit1; }
    public void setUnit1(U unit1) { 
        this.unit1 = unit1;
        this.unit1String = unit1 != null ? unit1.toString() : null;
    }
    
    public String getUnit1String() { return unit1String; }
    public void setUnit1String(String unit1String) { this.unit1String = unit1String; }

    public double getValue2() { return value2; }
    public void setValue2(double value2) { this.value2 = value2; }

    public U getUnit2() { return unit2; }
    public void setUnit2(U unit2) { 
        this.unit2 = unit2;
        this.unit2String = unit2 != null ? unit2.toString() : null;
    }

    public String getUnit2String() { return unit2String; }
    public void setUnit2String(String unit2String) { this.unit2String = unit2String; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public double getResultValue() { return resultValue; }
    public void setResultValue(double resultValue) { this.resultValue = resultValue; }

    public U getResultUnit() { return resultUnit; }
    public void setResultUnit(U resultUnit) { 
        this.resultUnit = resultUnit;
        this.resultUnitString = resultUnit != null ? resultUnit.toString() : null;
    }

    public String getResultUnitString() { return resultUnitString; }
    public void setResultUnitString(String resultUnitString) { this.resultUnitString = resultUnitString; }

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
