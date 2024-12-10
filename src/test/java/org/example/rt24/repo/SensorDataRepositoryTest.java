package org.example.rt24.repo;

import org.example.rt24.model.SensorData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class SensorDataRepositoryTest {

    @Autowired
    private SensorDataRepository repository;

    @Test
    public void testSaveAndFindSensorData() {
        SensorData data = new SensorData();
        data.setSensorId(1);
        data.setFormat("temperature");
        data.setUnit("celsius");
        data.setMeasurement(22.5);
        data.setRecord_time(LocalDateTime.now());

        SensorData savedData = repository.save(data);
        assertThat(savedData.getId()).isNotNull();

        SensorData foundData = repository.findById(savedData.getId().longValue()).orElse(null);
        assertThat(foundData).isNotNull();
        assertThat(foundData.getSensorId()).isEqualTo(data.getSensorId());
    }
}