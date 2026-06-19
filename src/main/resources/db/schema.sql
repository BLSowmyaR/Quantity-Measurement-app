CREATE TABLE IF NOT EXISTS quantity_measurement_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    value1 DOUBLE NOT NULL,
    unit1 VARCHAR(50) NOT NULL,
    value2 DOUBLE NOT NULL,
    unit2 VARCHAR(50) NOT NULL,
    operation VARCHAR(50) NOT NULL,
    result_value DOUBLE,
    result_unit VARCHAR(50),
    is_equality BOOLEAN,
    has_error BOOLEAN,
    error_message VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS quantity_measurement_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(50) NOT NULL,
    measurement_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
