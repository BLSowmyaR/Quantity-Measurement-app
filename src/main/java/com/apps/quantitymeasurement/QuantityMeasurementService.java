package com.apps.quantitymeasurement;

/**
 * Service Layer for Quantity Measurement Operations.
 * Encapsulates the business logic, mapping Entity requests to domain operations.
 * Part of UC-14: Service Layer Architecture.
 */
public class QuantityMeasurementService {

    /**
     * Compares two quantities for equality.
     */
    public <U extends IMeasurable> QuantityEntity<U> compareEquality(QuantityEntity<U> entity) {
        try {
            Quantity<U> q1 = new Quantity<>(entity.getValue1(), entity.getUnit1());
            Quantity<U> q2 = new Quantity<>(entity.getValue2(), entity.getUnit2());
            entity.setEquality(q1.equals(q2));
            entity.setHasError(false);
        } catch (Exception e) {
            handleException(entity, e);
        }
        return entity;
    }

    /**
     * Converts a quantity to a target unit.
     * Uses resultUnit as the target unit.
     */
    public <U extends IMeasurable> QuantityEntity<U> convert(QuantityEntity<U> entity) {
        try {
            Quantity<U> q1 = new Quantity<>(entity.getValue1(), entity.getUnit1());
            Quantity<U> result = q1.convertTo(entity.getResultUnit());
            entity.setResultValue(result.getValue());
            entity.setResultUnit(result.getUnit());
            entity.setHasError(false);
        } catch (Exception e) {
            handleException(entity, e);
        }
        return entity;
    }

    /**
     * Adds two quantities.
     * If resultUnit is set, uses it as the target. Otherwise uses unit1.
     */
    public <U extends IMeasurable> QuantityEntity<U> add(QuantityEntity<U> entity) {
        try {
            Quantity<U> q1 = new Quantity<>(entity.getValue1(), entity.getUnit1());
            Quantity<U> q2 = new Quantity<>(entity.getValue2(), entity.getUnit2());
            Quantity<U> result;
            if (entity.getResultUnit() != null) {
                result = q1.add(q2, entity.getResultUnit());
            } else {
                result = q1.add(q2);
            }
            entity.setResultValue(result.getValue());
            entity.setResultUnit(result.getUnit());
            entity.setHasError(false);
        } catch (Exception e) {
            handleException(entity, e);
        }
        return entity;
    }

    /**
     * Subtracts two quantities (q1 - q2).
     * If resultUnit is set, uses it as the target. Otherwise uses unit1.
     */
    public <U extends IMeasurable> QuantityEntity<U> subtract(QuantityEntity<U> entity) {
        try {
            Quantity<U> q1 = new Quantity<>(entity.getValue1(), entity.getUnit1());
            Quantity<U> q2 = new Quantity<>(entity.getValue2(), entity.getUnit2());
            Quantity<U> result;
            if (entity.getResultUnit() != null) {
                result = q1.subtract(q2, entity.getResultUnit());
            } else {
                result = q1.subtract(q2);
            }
            entity.setResultValue(result.getValue());
            entity.setResultUnit(result.getUnit());
            entity.setHasError(false);
        } catch (Exception e) {
            handleException(entity, e);
        }
        return entity;
    }

    /**
     * Divides q1 by q2, producing a dimensionless scalar result.
     */
    public <U extends IMeasurable> QuantityEntity<U> divide(QuantityEntity<U> entity) {
        try {
            Quantity<U> q1 = new Quantity<>(entity.getValue1(), entity.getUnit1());
            Quantity<U> q2 = new Quantity<>(entity.getValue2(), entity.getUnit2());
            double result = q1.divide(q2);
            entity.setResultValue(result);
            // No unit for division as it returns a ratio
            entity.setResultUnit(null); 
            entity.setHasError(false);
        } catch (Exception e) {
            handleException(entity, e);
        }
        return entity;
    }

    /**
     * Common exception handler to populate error fields on the entity.
     */
    private void handleException(QuantityEntity<?> entity, Exception e) {
        entity.setHasError(true);
        entity.setErrorMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
    }
}
