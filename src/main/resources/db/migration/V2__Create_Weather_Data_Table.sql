CREATE TABLE Data (
    id SERIAL PRIMARY KEY,
    sensor_id INT REFERENCES sensors(id) ON DELETE CASCADE,
    type VARCHAR(50) NOT NULL,
    unit VARCHAR(50) NOT NULL,
    value DOUBLE PRECISION NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    CONSTRAINT chk_valid_metric CHECK (value >= -100 AND value <= 1000)
);