-- 1. Display all machines

SELECT *
FROM machines;


-- 2. Display machine sensor data

SELECT
    reading_id,
    machine_id,
    air_temperature,
    process_temperature,
    rotational_speed,
    torque,
    tool_wear,
    reading_time
FROM machine_sensor_data
ORDER BY reading_id;


-- 3. Machines with high temperature

SELECT
    machine_id,
    air_temperature,
    process_temperature
FROM machine_sensor_data
WHERE air_temperature >= 302;


-- 4. Machines with high torque

SELECT
    machine_id,
    torque
FROM machine_sensor_data
WHERE torque >= 50;


-- 5. Failure predictions

SELECT
    prediction_id,
    machine_id,
    prediction_result,
    prediction_time
FROM predictions
WHERE prediction_result = 1
ORDER BY prediction_time DESC;


-- 6. Count failure and no-failure predictions

SELECT
    prediction_result,
    COUNT(*) AS prediction_count
FROM predictions
GROUP BY prediction_result
ORDER BY prediction_result;


-- 7. Recent predictions

SELECT
    prediction_id,
    machine_id,
    prediction_result,
    prediction_time
FROM predictions
ORDER BY prediction_time DESC;
