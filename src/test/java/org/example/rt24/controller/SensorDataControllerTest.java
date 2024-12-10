package org.example.rt24.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SensorDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSensorData() throws Exception {
        mockMvc.perform(get("/api/sensor-data/query?sensors=1,2,3&metrics=temperature,humidity&statistic=avg&from=2024-11-25T00:00:00&to=2024-12-15T23:59:59"))
                .andExpect(status().isOk());
    }
}
