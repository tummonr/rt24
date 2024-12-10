package org.example.rt24.service;

import org.example.rt24.repo.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    public Map<Integer, Map<String, Double>> querySensorData(List<Integer> sensors, List<String> metrics, String statistic, LocalDateTime from, LocalDateTime to) {
        Map<Integer, Map<String, Double>> queryResults = new HashMap<>();

        if (sensors == null) {
            sensors = sensorDataRepository.findAllDistinctSensorIds();
        }

        for (Integer sensor : sensors) {
            queryResults.put(sensor, new HashMap<>());
            for (String metric : metrics) {
                Double value = null;
                switch (statistic) {
                    case "avg":
                        value = sensorDataRepository.findAverage(sensor, metric, from, to);
                        break;
                    case "max":
                        value = sensorDataRepository.findMax(sensor, metric, from, to);
                        break;
                    case "min":
                        value = sensorDataRepository.findMin(sensor, metric, from, to);
                        break;
                    case "sum":
                        value = sensorDataRepository.findSum(sensor, metric, from, to);
                        break;
                }
                queryResults.get(sensor).put(metric + "_" + statistic, value);
            }
        }

        return queryResults;
    }
}
