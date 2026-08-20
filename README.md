# AI-Based Predictive Maintenance System for Industrial Machines

## Project Description

An academic predictive maintenance system that uses machine learning to predict whether an industrial machine is likely to experience a failure based on its operating parameters.

The project uses Python for machine learning, Oracle SQL for database storage, and Java with JDBC for database connectivity and application logic. Java uses `ProcessBuilder` to execute the Python prediction program and receive the prediction result.

## Problem Statement

Unexpected industrial machine failures can lead to downtime, maintenance costs, and production losses.

Predictive maintenance uses machine data and machine learning to identify whether a machine is likely to fail, helping demonstrate how maintenance decisions can be supported using data.

## Objective

To develop an academic prototype that:

- Stores machine data in Oracle SQL
- Retrieves machine data using Java and JDBC
- Processes machine data using Python
- Trains a Random Forest classification model
- Evaluates the machine learning model
- Predicts failure or no failure for new machine data
- Demonstrates Java-to-Python integration using `ProcessBuilder`

## Features

- Machine sensor data storage
- Oracle SQL database
- Java and JDBC connectivity
- Python-based machine learning
- Pandas and NumPy for data processing
- Random Forest Classifier
- Train-test split
- Model evaluation
- Accuracy calculation
- Confusion matrix
- Classification report
- Prediction on new machine data
- Java-to-Python integration using `ProcessBuilder`
- Trained model storage using `joblib`

## Technologies Used

- **Programming:** Java, Python
- **Database:** Oracle SQL
- **Database Connectivity:** JDBC
- **Machine Learning:** Scikit-learn
- **Data Processing:** Pandas, NumPy
- **Model Storage:** Joblib
- **Development Environment:** Eclipse, VS Code/Python environment
- **Dataset:** AI4I 2020 Predictive Maintenance Dataset
- **Version Control:** Git & GitHub

## Architecture

```text
                 Oracle Database
                       ↓
                  Java + JDBC
                       ↓
              Machine Parameters
                       ↓
                ProcessBuilder
                       ↓
                Python predict.py
                       ↓
             Random Forest Model
                       ↓
               Machine Prediction
                       ↓
              Failure / No Failure
```

## Workflow

1. Machine data is stored in the Oracle database.
2. Java connects to Oracle using JDBC.
3. Java retrieves the required machine parameters.
4. Java passes the parameters to the Python prediction program using `ProcessBuilder`.
5. Python loads the trained Random Forest model using `joblib`.
6. The model predicts whether the machine will fail.
7. Python returns the prediction result.
8. Java displays the prediction result.

## Dataset

This project uses the **AI4I 2020 Predictive Maintenance Dataset**.

The dataset contains machine parameters such as:

- Air temperature
- Process temperature
- Rotational speed
- Torque
- Tool wear

The target variable is:

```text
Machine failure

0 = No Failure
1 = Failure
```

The dataset should be downloaded separately and placed inside the `dataset` folder if permitted.

## Machine Learning Approach

The project uses a **Random Forest Classifier**.

### Input Features

```text
Air temperature [K]
Process temperature [K]
Rotational speed [rpm]
Torque [Nm]
Tool wear [min]
```

### Target

```text
Machine failure
```

The dataset is divided into training and testing data using `train_test_split`.

The Random Forest model is trained using the training data and evaluated using the testing data.

## Model Evaluation

The model is evaluated using:

- Accuracy
- Confusion Matrix
- Classification Report

The actual evaluation values depend on the dataset and the model execution.

## Prediction

After training, the Random Forest model is saved using `joblib`.

```text
train_model.py
       ↓
Random Forest Model
       ↓
joblib
       ↓
random_forest_model.pkl
```

The `predict.py` program loads the saved model and accepts new machine parameters.

Example prediction:

```text
Predicted No Failure
```

or:

```text
Predicted Failure
```

## Java / JDBC

Java is used as the application layer.

JDBC is used to connect Java with the Oracle database.

The Java application retrieves machine parameters from the database and prepares them for prediction.

## Java-Python Integration

The project demonstrates Java-to-Python integration using Java's `ProcessBuilder`.

The basic flow is:

```text
Java
 ↓
ProcessBuilder
 ↓
predict.py
 ↓
Random Forest
 ↓
Prediction
 ↓
Java
```

Java passes the machine parameters to the Python program as command-line arguments.

Python performs the prediction and returns the result to Java.

This is a simple academic integration approach and is not intended as a production-level architecture.

## Project Structure

```text
AI-PREDICTIVE-MAINTENANCE-SYSTEM/
│
├── README.md
├── .gitignore
│
├── python/
│   ├── train_model.py
│   ├── predict.py
│   └── requirements.txt
│
├── java/
│   ├── DBConnection.java
│   ├── MachineData.java
│   ├── Prediction.java
│   └── Main.java
│
├── sql/
│   ├── create_tables.sql
│   ├── insert_sample_data.sql
│   └── queries.sql
│
└── dataset/
    └── README.md
```

## Installation

### Python Setup

Install Python on your computer.

Install the project dependencies:

```bash
pip install -r python/requirements.txt
```

The required libraries include:

```text
pandas
numpy
scikit-learn
joblib
```

### Oracle Setup

Run the SQL scripts in the following order:

```text
sql/create_tables.sql
sql/insert_sample_data.sql
```

Configure the Oracle username and password in:

```text
java/DBConnection.java
```

Use your own local credentials.

Never upload real passwords to GitHub.

### Java Setup

Open the Java files in Eclipse.

Add the Oracle JDBC driver to the Java project.

Update the database connection details in:

```text
java/DBConnection.java
```

## Running Instructions

### Step 1 — Prepare the Dataset

Download the AI4I 2020 Predictive Maintenance Dataset.

Place the CSV file as:

```text
dataset/ai4i2020.csv
```

if permitted.

### Step 2 — Train the Model

Run:

```bash
python python/train_model.py
```

This trains the Random Forest model and saves the trained model using `joblib`.

### Step 3 — Test Python Prediction

Run:

```bash
python python/predict.py 300.5 310.2 1500 40 100
```

The program will display either:

```text
Predicted No Failure
```

or:

```text
Predicted Failure
```

### Step 4 — Configure Oracle

Run the SQL files:

```text
sql/create_tables.sql
sql/insert_sample_data.sql
```

Make sure the Oracle database is running.

### Step 5 — Configure Java

Open the Java project in Eclipse.

Update your Oracle username and password in:

```text
java/DBConnection.java
```

Do not upload your actual password to GitHub.

### Step 6 — Run Java Application

Run:

```text
Main.java
```

The Java program:

1. Connects to Oracle.
2. Retrieves machine data.
3. Passes the machine parameters to Python.
4. Executes `predict.py` using `ProcessBuilder`.
5. Receives the prediction.
6. Displays the prediction result.

## Sample Output

Example output:

```text
Oracle database connected successfully.

----- Machine Data -----
Machine ID: 1
Air Temperature: 300.5
Process Temperature: 310.2
Rotational Speed: 1500.0
Torque: 40.0
Tool Wear: 100.0
------------------------

----- Prediction Result -----
Machine ID: 1
Prediction: Predicted No Failure
-----------------------------
```

The actual prediction depends on the trained model and machine input values.

## Model Evaluation Example

Example output format:

```text
Accuracy: XX.XX

Confusion Matrix:
[[... ...]
 [... ...]]

Classification Report:
              precision    recall    f1-score

...
```

The values shown above are only an example format.

The actual accuracy, confusion matrix, and classification report are generated when the model is trained and tested.

## Oracle Database

The Oracle database stores machine and sensor information used by the Java application.

The project uses tables for:

- Machine information
- Sensor data
- Prediction history

Java uses JDBC to retrieve the required machine parameters from Oracle.

## SQL Queries

The SQL folder contains scripts for:

- Creating database tables
- Inserting sample machine data
- Retrieving machine information
- Checking sensor values
- Viewing prediction information

## Python Machine Learning

Python is responsible for the machine learning part of the project.

The main Python programs are:

```text
train_model.py
predict.py
```

### train_model.py

The training program:

1. Loads the AI4I 2020 dataset.
2. Selects the required machine parameters.
3. Separates features and target.
4. Splits the data into training and testing sets.
5. Trains the Random Forest Classifier.
6. Makes predictions on the test data.
7. Evaluates the model.
8. Saves the trained model using `joblib`.

### predict.py

The prediction program:

1. Loads the trained Random Forest model.
2. Receives machine parameters.
3. Creates the required input format.
4. Performs prediction.
5. Returns either Failure or No Failure.

## Java-Python Integration

The Java application uses `ProcessBuilder` to execute the Python prediction program.

Example flow:

```text
Oracle Database
      ↓
Java + JDBC
      ↓
Machine Data
      ↓
ProcessBuilder
      ↓
Python predict.py
      ↓
Random Forest Model
      ↓
Prediction
      ↓
Java
```

This allows the Java application to use the Python machine learning model.

## Security

Never upload sensitive information to GitHub.

Do not upload:

```text
Oracle passwords
Wi-Fi passwords
API keys
Access tokens
Private keys
.env files containing secrets
```

Use placeholders such as:

```text
your_username
your_password
```

in the source code.

## Limitations

- This is an academic prototype.
- The AI4I 2020 dataset is used for machine learning.
- The project does not use real industrial machine sensors.
- The model is not deployed as a production system.
- Java-to-Python communication uses `ProcessBuilder` as a simple academic integration method.
- The project is not intended for real industrial maintenance decisions.
- The model prediction should not be treated as a guarantee of actual machine failure.

## Future Enhancements

- Real-time sensor data integration
- Real industrial machine data
- REST API-based Java-Python integration
- Real-time prediction system
- Machine monitoring dashboard
- Historical prediction analysis
- Cloud deployment
- Integration with industrial IoT systems

## Skills Demonstrated

- Java programming
- Object-Oriented Programming
- Oracle SQL
- JDBC
- Python programming
- Pandas
- NumPy
- Scikit-learn
- Random Forest Classification
- Train-test split
- Model evaluation
- Joblib model persistence
- Java-Python integration using ProcessBuilder
- Git and GitHub
- Basic system architecture

## Author

**Suhas M Bharadwaj**

B.E. Mechanical Engineering  
JSS Science and Technology University, Mysuru
