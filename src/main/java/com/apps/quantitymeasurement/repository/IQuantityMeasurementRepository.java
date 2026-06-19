package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.QuantityEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {
    void save(QuantityEntity<?> entity);
    List<QuantityEntity<?>> getAllMeasurements();
    List<QuantityEntity<?>> getMeasurementsByOperation(String operation);
    List<QuantityEntity<?>> getMeasurementsByType(String type);
    int getTotalCount();
    void deleteAll();
    
    default String getPoolStatistics() {
        return "No pool statistics available.";
    }
    
    default void releaseResources() {}
}
