package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.LengthUnit;
import com.apps.quantitymeasurement.QuantityEntity;
import com.apps.quantitymeasurement.QuantityMeasurementService;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService service;

    @MockBean
    private IQuantityMeasurementRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void testCompareEquality() throws Exception {
        QuantityEntity<LengthUnit> request = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "EQUALITY");
        
        QuantityEntity<LengthUnit> response = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "EQUALITY");
        response.setEquality(true);
        
        Mockito.when(service.compareEquality(any())).thenReturn((QuantityEntity) response);

        mockMvc.perform(post("/api/v1/quantities/compare")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(org.springframework.test.web.servlet.result.MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("EQUALITY"))
                .andExpect(jsonPath("$.equality").value(true));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void testAdd() throws Exception {
        QuantityEntity<LengthUnit> request = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "ADDITION");
        
        QuantityEntity<LengthUnit> response = new QuantityEntity<>(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, "ADDITION");
        response.setResultValue(2.0);
        response.setResultUnitString("FEET");
        
        Mockito.when(service.add(any())).thenReturn((QuantityEntity) response);

        mockMvc.perform(post("/api/v1/quantities/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("ADDITION"))
                .andExpect(jsonPath("$.resultValue").value(2.0))
                .andExpect(jsonPath("$.resultUnitString").value("FEET"));
    }

    @Test
    public void testCountByOperation() throws Exception {
        Mockito.when(repository.findByOperation("EQUALITY")).thenReturn(List.of(new QuantityEntity<>(), new QuantityEntity<>()));

        mockMvc.perform(get("/api/v1/quantities/count/equality"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2))
                .andExpect(jsonPath("$.operation").value("equality"));
    }
}
