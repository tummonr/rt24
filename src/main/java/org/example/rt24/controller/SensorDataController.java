package org.example.rt24.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.rt24.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensor-data")
@Slf4j
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping("/query")
    public ResponseEntity<Object> querySensorData(
            @RequestParam(required = false) List<Integer> sensors,
            @RequestParam List<String> metrics,
            @RequestParam String statistic,
            @RequestParam(required = false) LocalDateTime from,
            @RequestParam(required = false) LocalDateTime to) {

        if (from == null && to == null) {
            to = LocalDateTime.now();
            from = to.minusDays(1);
        }
        if (from == null && to != null) {
            from = to.minusDays(1);
        }
        if (from != null && to == null) {
            to = LocalDateTime.now();
        }
        if (from.isAfter(to)) {
            return ResponseEntity.badRequest().body("Invalid date range: 'from' should be before 'to'.");
        }
        long daysBetween = Duration.between(from, to).toDays();
        if (daysBetween > 31) {
            return ResponseEntity.badRequest().body("Date range cannot exceed 31 days.");
        } else if (daysBetween < 1) {
            return ResponseEntity.badRequest().body("Date range cannot be less than 1 day.");
        }
        if (sensors.isEmpty() || metrics.isEmpty()) {
            return ResponseEntity.badRequest().body("Sensors and metrics lists cannot be empty.");
        }

        if (!isValidStatistic(statistic)) {
            return ResponseEntity.badRequest().body("Invalid statistic value. Allowed values are: avg, min, max, sum.");
        }

        try {
            if (sensors == null || sensors.isEmpty() || sensors.contains(-1)) {
                sensors = null;
            }
            Map<Integer, Map<String, Double>> results = sensorDataService.querySensorData(sensors, metrics, statistic, from, to);
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            log.error("An error occurred while processing request: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing request");
        }
    }

    private boolean isValidStatistic(String statistic) {
        return List.of("avg", "min", "max", "sum").contains(statistic);
    }
}