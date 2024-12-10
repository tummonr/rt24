package org.example.rt24.service;

import org.example.rt24.model.SensorData;
import org.example.rt24.repo.SensorDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SensorDataServiceTest {

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @BeforeEach
    public void setUp() {
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(1);
        sensorData.setMeasurement(22.5);
        sensorData.setRecord_time(LocalDateTime.now().minusDays(1));
        sensorData.setFormat("temperature");
        sensorData.setUnit("celsius");
        sensorDataRepository.save(sensorData);

        SensorData sensorData2 = new SensorData();
        sensorData2.setSensorId(1);
        sensorData2.setMeasurement(23.5);
        sensorData2.setRecord_time(LocalDateTime.now());
        sensorData2.setFormat("temperature");
        sensorData2.setUnit("celsius");
        sensorDataRepository.save(sensorData2);
    }

    @Test
    public void testGetSensorData() {
        List<SensorData> data = sensorDataRepository.findAll();
        data.forEach(s -> System.out.println(s.getMeasurement()));
        Map<Integer, Map<String, Double>> retrievedData = sensorDataService.querySensorData(List.of(1),List.of("temperature"), "avg", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1));

        assertNotNull(retrievedData);

        System.out.println(retrievedData.toString());
        assertEquals(23, retrievedData.get(1).get("temperature_avg"));
    }
}