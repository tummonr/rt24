package org.example.rt24.repo;

import org.example.rt24.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    @Query("SELECT AVG(s.measurement) FROM SensorData s WHERE s.sensorId = :sensorId AND s.format = :format AND s.record_time BETWEEN :startDate AND :endDate")
    Double findAverage(@Param("sensorId") Integer sensorId,
                       @Param("format") String format,
                       @Param("startDate") LocalDateTime startDate,
                       @Param("endDate") LocalDateTime endDate);

    @Query("SELECT MAX(s.measurement) FROM SensorData s WHERE s.sensorId = :sensorId AND s.format = :format AND s.record_time BETWEEN :startDate AND :endDate")
    Double findMax(@Param("sensorId") Integer sensorId,
                   @Param("format") String format,
                   @Param("startDate") LocalDateTime startDate,
                   @Param("endDate") LocalDateTime endDate);

    @Query("SELECT MIN(s.measurement) FROM SensorData s WHERE s.sensorId = :sensorId AND s.format = :format AND s.record_time BETWEEN :startDate AND :endDate")
    Double findMin(@Param("sensorId") Integer sensorId,
                   @Param("format") String format,
                   @Param("startDate") LocalDateTime startDate,
                   @Param("endDate") LocalDateTime endDate);

    @Query("SELECT SUM(s.measurement) FROM SensorData s WHERE s.sensorId = :sensorId AND s.format = :format AND s.record_time BETWEEN :startDate AND :endDate")
    Double findSum(@Param("sensorId") Integer sensorId,
                   @Param("format") String format,
                   @Param("startDate") LocalDateTime startDate,
                   @Param("endDate") LocalDateTime endDate);

    @Query("SELECT DISTINCT s.sensorId FROM SensorData s")
    List<Integer> findAllDistinctSensorIds();
}