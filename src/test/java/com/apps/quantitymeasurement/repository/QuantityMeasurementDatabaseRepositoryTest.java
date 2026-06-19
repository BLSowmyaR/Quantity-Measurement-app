package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.LengthUnit;
import com.apps.quantitymeasurement.QuantityEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementDatabaseRepositoryTest {

    private QuantityMeasurementDatabaseRepository repository;

    @BeforeEach
    public void setUp() {
        System.setProperty("repository.type", "database");
        System.setProperty("db.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        System.setProperty("db.username", "sa");
        System.setProperty("db.password", "");
        System.setProperty("pool.size", "5");
        
        repository = new QuantityMeasurementDatabaseRepository();
        repository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        if (repository != null) {
            repository.deleteAll();
        }
    }

    @Test
    public void testRepository_SaveAndRetrieveAll() {
        QuantityEntity<LengthUnit> entity = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "EQUALITY");
        entity.setEquality(true);
        
        repository.save(entity);
        
        List<QuantityEntity<?>> measurements = repository.getAllMeasurements();
        assertEquals(1, measurements.size());
        
        QuantityEntity<?> saved = measurements.get(0);
        assertEquals(1.0, saved.getValue1(), 1e-9);
        assertEquals(12.0, saved.getValue2(), 1e-9);
        assertEquals("EQUALITY", saved.getOperation());
        assertTrue(saved.isEquality());
    }

    @Test
    public void testRepository_QueryByOperation() {
        QuantityEntity<LengthUnit> e1 = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "ADDITION");
        QuantityEntity<LengthUnit> e2 = new QuantityEntity<>(2.0, LengthUnit.FEET, 24.0, LengthUnit.INCHES, "EQUALITY");
        
        repository.save(e1);
        repository.save(e2);
        
        List<QuantityEntity<?>> additions = repository.getMeasurementsByOperation("ADDITION");
        assertEquals(1, additions.size());
        assertEquals("ADDITION", additions.get(0).getOperation());
        
        List<QuantityEntity<?>> equalities = repository.getMeasurementsByOperation("EQUALITY");
        assertEquals(1, equalities.size());
        assertEquals("EQUALITY", equalities.get(0).getOperation());
    }

    @Test
    public void testRepository_TotalCount() {
        assertEquals(0, repository.getTotalCount());
        
        repository.save(new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "EQUALITY"));
        repository.save(new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "ADDITION"));
        
        assertEquals(2, repository.getTotalCount());
    }

    @Test
    public void testRepository_DeleteAll() {
        repository.save(new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "EQUALITY"));
        assertEquals(1, repository.getTotalCount());
        
        repository.deleteAll();
        assertEquals(0, repository.getTotalCount());
    }

    @Test
    public void testRepository_PoolStatistics() {
        String stats = repository.getPoolStatistics();
        assertNotNull(stats);
        assertTrue(stats.contains("Pool Size"));
    }
}
