INSERT INTO machines (
    machine_name,
    machine_type,
    installation_date
)
VALUES (
    'Machine-001',
    'Industrial Machine',
    DATE '2024-01-15'
);


INSERT INTO machines (
    machine_name,
    machine_type,
    installation_date
)
VALUES (
    'Machine-002',
    'Industrial Machine',
    DATE '2024-02-20'
);


INSERT INTO machines (
    machine_name,
    machine_type,
    installation_date
)
VALUES (
    'Machine-003',
    'Industrial Machine',
    DATE '2024-03-10'
);


INSERT INTO machine_sensor_data (
    machine_id,
    air_temperature,
    process_temperature,
    rotational_speed,
    torque,
    tool_wear
)
VALUES (
    1,
    300.5,
    310.2,
    1500,
    40.0,
    100
);


INSERT INTO machine_sensor_data (
    machine_id,
    air_temperature,
    process_temperature,
    rotational_speed,
    torque,
    tool_wear
)
VALUES (
    2,
    302.0,
    312.5,
    1400,
    55.0,
    180
);


INSERT INTO machine_sensor_data (
    machine_id,
    air_temperature,
    process_temperature,
    rotational_speed,
    torque,
    tool_wear
)
VALUES (
    3,
    299.5,
    309.8,
    1600,
    35.0,
    70
);


INSERT INTO predictions (
    machine_id,
    prediction_result
)
VALUES (
    1,
    0
);


INSERT INTO predictions (
    machine_id,
    prediction_result
)
VALUES (
    2,
    1
);


INSERT INTO predictions (
    machine_id,
    prediction_result
)
VALUES (
    3,
    0
);


COMMIT;
