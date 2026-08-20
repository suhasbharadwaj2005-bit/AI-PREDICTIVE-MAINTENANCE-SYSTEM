import sys
import joblib
import pandas as pd


# --------------------------------------------------
# 1. Load the trained Random Forest model
# --------------------------------------------------

model = joblib.load("python/random_forest_model.pkl")


# --------------------------------------------------
# 2. Read machine parameters from Java
# --------------------------------------------------

air_temperature = float(sys.argv[1])
process_temperature = float(sys.argv[2])
rotational_speed = float(sys.argv[3])
torque = float(sys.argv[4])
tool_wear = float(sys.argv[5])


# --------------------------------------------------
# 3. Create DataFrame with the same feature names
# --------------------------------------------------

machine_data = pd.DataFrame([
    {
        "Air temperature [K]": air_temperature,
        "Process temperature [K]": process_temperature,
        "Rotational speed [rpm]": rotational_speed,
        "Torque [Nm]": torque,
        "Tool wear [min]": tool_wear
    }
])


# --------------------------------------------------
# 4. Make prediction
# --------------------------------------------------

prediction = model.predict(machine_data)[0]


# --------------------------------------------------
# 5. Display prediction
# --------------------------------------------------

if prediction == 1:
    print("Predicted Failure")
else:
    print("Predicted No Failure")
