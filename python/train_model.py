import os
import pandas as pd
import joblib

from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import (
    accuracy_score,
    confusion_matrix,
    classification_report
)

import joblib


# Get project folder path
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# Dataset path
DATASET_PATH = os.path.join(
    BASE_DIR,
    "dataset",
    "ai4i2020.csv"
)

# Model path
MODEL_DIR = os.path.join(BASE_DIR, "model")
MODEL_PATH = os.path.join(
    MODEL_DIR,
    "random_forest_model.joblib"
)


# 1. Load dataset
print("Loading dataset...")

df = pd.read_csv(DATASET_PATH)

print("Dataset loaded successfully.")
print("Number of records:", len(df))


# 2. Select machine parameters
features = [
    "Air temperature [K]",
    "Process temperature [K]",
    "Rotational speed [rpm]",
    "Torque [Nm]",
    "Tool wear [min]"
]

target = "Machine failure"

X = df[features]
y = df[target]


# 3. Split dataset into training and testing data
X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.20,
    random_state=42,
    stratify=y
)

print("Training records:", len(X_train))
print("Testing records:", len(X_test))


# 4. Create Random Forest model
model = RandomForestClassifier(
    n_estimators=100,
    random_state=42
)


# 5. Train the model
print("\nTraining Random Forest model...")

model.fit(X_train, y_train)

print("Model training completed.")


# 6. Make predictions
y_pred = model.predict(X_test)


# 7. Evaluate model
accuracy = accuracy_score(y_test, y_pred)

print("\nAccuracy:")
print(f"{accuracy:.4f}")

print("\nConfusion Matrix:")
print(confusion_matrix(y_test, y_pred))

print("\nClassification Report:")
print(classification_report(y_test, y_pred))


# 8. Save trained model
os.makedirs(MODEL_DIR, exist_ok=True)

joblib.dump(model, MODEL_PATH)

print("\nTrained model saved successfully.")
print("Model location:", MODEL_PATH)

joblib.dump(model, "python/random_forest_model.pkl")
