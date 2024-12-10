CREATE TABLE IF NOT EXISTS sensor_data (
    id SERIAL PRIMARY KEY,
    sensor_id INT,
    format VARCHAR(50) NOT NULL,
    unit VARCHAR(50) NOT NULL,
    measurement DOUBLE PRECISION NOT NULL,
    record_time TIMESTAMP NOT NULL
);

ALTER USER rory PASSWORD 'notagoodpassword';
GRANT ALL PRIVILEGES ON sensor_data TO rory;