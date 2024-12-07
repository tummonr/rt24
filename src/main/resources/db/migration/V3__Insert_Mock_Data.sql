INSERT INTO sensors (name, location) VALUES
    ('Main', 'Galway'),
    ('Rooftop', 'Dublin'),
    ('Home', 'Kerry');

INSERT INTO weather_metrics (sensor_id, type, unit, value, timestamp) VALUES
    (1, 'temperature', 'celsius', 22.5, '2024-12-01T10:00:00'),
    (1, 'humidity', 'percent', 60.0, '2024-12-01T10:00:00'),
    (2, 'temperature', 'celsius', 18.0, '2024-12-01T11:00:00'),
    (2, 'wind_speed', 'kmh', 5.5, '2024-12-01T11:00:00'),
    (3, 'temperature', 'celsius', 15.5, '2024-12-01T12:00:00'),
    (3, 'humidity', 'percent', 55.0, '2024-12-01T12:00:00');