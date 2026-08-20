import os
import pandas as pd
import joblib


# Get project folder path
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# Trained model path
MODEL_PATH = os.path.join(
    BASE_DIR,
    "model",
    "random_forest_model.joblib"
)


# 1. Load trained model
if not os.path.exists(MODEL_PATH):
    print("Trained model not found.")
    print("Please run train_model.py first.")
    exit()

model = joblib.load(MODEL_PATH)

print("Random Forest model loaded successfully.")


# 2. Sample machine data
air_temperature = 300.0
process_temperature = 310.0
rotational_speed = 1500
torque = 40.0
tool_wear = 100


# 3. Create DataFrame
machine_data = pd.DataFrame([
    {
        "Air temperature [K]": air_temperature,
        "Process temperature [K]": process_temperature,
        "Rotational speed [rpm]": rotational_speed,
        "Torque [Nm]": torque,
        "Tool wear [min]": tool_wear
    }
])


# 4. Make prediction
prediction = model.predict(machine_data)[0]


# 5. Display machine data
print("\nMachine Parameters:")
print(machine_data)


# 6. Display prediction
print("\nPrediction:")

if prediction == 1:
    print("Predicted Failure")
else:
    print("Predicted No Failure")
