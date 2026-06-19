package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.QuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuantityMeasurementRepository extends JpaRepository<QuantityEntity<?>, Long> {
    
    List<QuantityEntity<?>> findByOperation(String operation);
    
    // Custom query to find by unit type string
    List<QuantityEntity<?>> findByUnit1StringContaining(String type);
}
