package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.*;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    private final QuantityMeasurementService service;
    private final IQuantityMeasurementRepository repository;

    @Autowired
    public QuantityMeasurementController(QuantityMeasurementService service, IQuantityMeasurementRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    
    @SuppressWarnings("unchecked")
    private <U extends IMeasurable> void populateUnits(QuantityEntity<U> entity) {
        if (entity.getUnit1String() != null) {
            entity.setUnit1((U) parseUnit(entity.getUnit1String()));
        }
        if (entity.getUnit2String() != null) {
            entity.setUnit2((U) parseUnit(entity.getUnit2String()));
        }
    }

    private IMeasurable parseUnit(String unitString) {
        if (unitString == null) return null;
        try { return LengthUnit.valueOf(unitString.toUpperCase()); } catch (IllegalArgumentException e) {}
        try { return VolumeUnit.valueOf(unitString.toUpperCase()); } catch (IllegalArgumentException e) {}
        try { return WeightUnit.valueOf(unitString.toUpperCase()); } catch (IllegalArgumentException e) {}
        throw new IllegalArgumentException("Unknown unit: " + unitString);
    }

    @PostMapping("/compare")
    public ResponseEntity<QuantityEntity<?>> compareEquality(@RequestBody QuantityEntity<?> entity) {
        populateUnits(entity);
        entity.setOperation("EQUALITY");
        return ResponseEntity.ok(service.compareEquality(entity));
    }

    @PostMapping("/convert")
    public ResponseEntity<QuantityEntity<?>> convert(@RequestBody QuantityEntity<?> entity) {
        populateUnits(entity);
        entity.setOperation("CONVERSION");
        return ResponseEntity.ok(service.convert(entity));
    }

    @PostMapping("/add")
    public ResponseEntity<QuantityEntity<?>> add(@RequestBody QuantityEntity<?> entity) {
        populateUnits(entity);
        entity.setOperation("ADDITION");
        return ResponseEntity.ok(service.add(entity));
    }

    @PostMapping("/subtract")
    public ResponseEntity<QuantityEntity<?>> subtract(@RequestBody QuantityEntity<?> entity) {
        populateUnits(entity);
        entity.setOperation("SUBTRACTION");
        return ResponseEntity.ok(service.subtract(entity));
    }

    @PostMapping("/divide")
    public ResponseEntity<QuantityEntity<?>> divide(@RequestBody QuantityEntity<?> entity) {
        populateUnits(entity);
        entity.setOperation("DIVISION");
        return ResponseEntity.ok(service.divide(entity));
    }

    @GetMapping("/count/{operation}")
    public ResponseEntity<Map<String, Object>> countByOperation(@PathVariable String operation) {
        long count = repository.findByOperation(operation.toUpperCase()).size();
        return ResponseEntity.ok(Map.of("operation", operation, "count", count));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<QuantityEntity<?>>> getAllMeasurements() {
        return ResponseEntity.ok(repository.findAll());
    }
}
