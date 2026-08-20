# AI-Based Predictive Maintenance System for Industrial Machines

## Project Overview

An AI-based predictive maintenance system that uses machine sensor data and machine learning to predict whether an industrial machine is likely to experience a failure.

The project combines **Python Machine Learning, Java, JDBC, and Oracle SQL** to demonstrate how an industrial predictive maintenance workflow can be designed.

The system uses the **AI4I 2020 Predictive Maintenance Dataset**, which contains machine parameters such as air temperature, process temperature, rotational speed, torque, and tool wear.

---

## Problem Statement

Industrial machine failures can cause:

* Unexpected production downtime
* Increased maintenance costs
* Reduced productivity
* Equipment damage
* Safety risks

Traditional maintenance methods are mainly:

**Reactive Maintenance**
Repair the machine after it fails.

**Preventive Maintenance**
Perform maintenance at fixed time intervals.

**Predictive Maintenance**
Use machine data and machine learning to predict possible failures before they occur.

This project demonstrates the basic concept of **AI-based predictive maintenance** using historical machine sensor data.

---

## Objective

The main objectives of this project are:

* Store machine and sensor information using Oracle SQL
* Process machine sensor data using Python
* Train a machine learning classification model
* Use Random Forest to predict machine failure
* Evaluate the machine learning model
* Demonstrate Java database connectivity using JDBC
* Design an end-to-end predictive maintenance architecture

---

## Technologies Used

| Technology    | Purpose                                     |
| ------------- | ------------------------------------------- |
| Java          | Backend application and database operations |
| JDBC          | Connecting Java with Oracle Database        |
| Oracle SQL    | Storing machine, sensor and prediction data |
| Python        | Machine learning and data processing        |
| Pandas        | Dataset handling and preprocessing          |
| NumPy         | Numerical operations                        |
| Scikit-learn  | Machine learning                            |
| Random Forest | Failure classification                      |
| Git & GitHub  | Version control and project documentation   |

---

## System Architecture

```text
Industrial Machine / Dataset
           |
           v
     Sensor Data
           |
           v
     Oracle Database
           |
           v
      Java Backend
        (JDBC)
           |
           v
     Python ML Layer
           |
           v
   Data Preprocessing
           |
           v
    Random Forest Model
           |
           v
     Failure Prediction
           |
           v
   Prediction History
```

### Architecture Explanation

The project is divided into three main layers:

**1. Database Layer**

Oracle SQL stores machine information, sensor readings, and prediction history.

**2. Backend Layer**

Java connects to the Oracle database using JDBC and performs database operations.

**3. Machine Learning Layer**

Python processes the sensor dataset, trains the Random Forest model, evaluates the model, and generates predictions.

---

## Project Workflow

```text
Machine Sensor Data
        |
        v
Oracle Database
        |
        v
Java + JDBC
        |
        v
Historical Sensor Data
        |
        v
Python Preprocessing
        |
        v
Train-Test Split
        |
        v
Random Forest Training
        |
        v
Model Evaluation
        |
        v
New Sensor Data
        |
        v
Failure Prediction
```

---

## Dataset

This project uses the **AI4I 2020 Predictive Maintenance Dataset**.

The dataset contains synthetic but realistic industrial machine data.

Important parameters include:

* Air Temperature
* Process Temperature
* Rotational Speed
* Torque
* Tool Wear
* Machine Failure

These parameters are used as input features for the machine learning model.

---

## Machine Learning

The machine learning part of the project uses **Scikit-learn**.

### Machine Learning Workflow

```text
Load Dataset
     |
     v
Clean Data
     |
     v
Select Features
     |
     v
Train-Test Split
     |
     v
Train Random Forest
     |
     v
Evaluate Model
     |
     v
Predict New Data
```

### Selected Features

The model uses machine parameters such as:

```text
Air Temperature
Process Temperature
Rotational Speed
Torque
Tool Wear
```

### Target

The target variable is:

```text
Machine Failure
```

The model predicts:

```text
0 → No Failure
1 → Failure
```

---

## Random Forest Classifier

A **Random Forest Classifier** is used for machine failure prediction.

Random Forest is an ensemble machine learning algorithm that combines multiple decision trees to make a final prediction.

For example:

```text
Sensor Data
    |
    +---- Decision Tree 1 ----> No Failure
    |
    +---- Decision Tree 2 ----> Failure
    |
    +---- Decision Tree 3 ----> No Failure
    |
    +---- Decision Tree 4 ----> No Failure
    |
    +---- Decision Tree 5 ----> No Failure
              |
              v
        Final Prediction
          No Failure
```

---

## Model Evaluation

The trained model can be evaluated using:

### Accuracy

Measures the percentage of correct predictions.

### Confusion Matrix

Shows:

* True Negative
* False Positive
* False Negative
* True Positive

Example:

```text
                  Predicted
                No Failure  Failure

Actual
No Failure        TN          FP

Failure           FN          TP
```

### Classification Report

The classification report provides:

* Precision
* Recall
* F1-score
* Support

---

## Prediction

After training the model, new machine sensor values can be provided to the prediction script.

Example:

```text
Air Temperature     = 300 K
Process Temperature = 310 K
Rotational Speed    = 1500 RPM
Torque              = 40 Nm
Tool Wear           = 100 min
```

The trained model processes these values and predicts:

```text
Prediction: No Failure
```

or

```text
Prediction: Machine Failure
```

The actual prediction depends on the trained model and input values.

---

## Oracle Database

The project uses Oracle SQL to represent a simplified **Computerized Maintenance Management System (CMMS)** database.

Three core tables are planned:

### 1. MACHINE

Stores machine information.

Example fields:

```text
MACHINE_ID
MACHINE_NAME
MACHINE_TYPE
LOCATION
STATUS
```

### 2. SENSOR_DATA

Stores sensor readings.

Example fields:

```text
SENSOR_ID
MACHINE_ID
AIR_TEMPERATURE
PROCESS_TEMPERATURE
ROTATIONAL_SPEED
TORQUE
TOOL_WEAR
RECORDED_TIME
```

### 3. PREDICTION_HISTORY

Stores machine learning predictions.

Example fields:

```text
PREDICTION_ID
MACHINE_ID
PREDICTION
PREDICTION_TIME
MODEL_NAME
```

---

## Java Backend

The Java backend is used to communicate with the Oracle database.

The project uses:

* Java OOP
* JDBC
* DAO Pattern
* CRUD Operations

### Java Backend Responsibilities

```text
Java Application
      |
      v
     JDBC
      |
      v
Oracle Database
```

The Java application can perform operations such as:

* Add machine
* View machine
* Update machine
* Delete machine
* Store sensor data
* View prediction history

---

## JDBC

**JDBC** stands for:

**Java Database Connectivity**

It allows a Java application to communicate with a relational database.

Basic flow:

```text
Java Application
       |
       v
 JDBC Driver
       |
       v
Oracle Database
```

---

## DAO Pattern

The project follows the **Data Access Object (DAO)** pattern.

DAO separates database operations from the main application logic.

Example:

```text
Java Application
       |
       v
    Service
       |
       v
      DAO
       |
       v
    JDBC
       |
       v
Oracle Database
```

This makes the backend easier to organize and maintain.

---

## Python ML Structure

The Python machine learning section is organized into separate scripts.

```text
python-ml/
│
├── preprocessing.py
├── train_model.py
├── evaluate_model.py
├── predict.py
└── requirements.txt
```

### preprocessing.py

Used for:

* Loading the dataset
* Cleaning data
* Selecting features
* Preparing data for machine learning

### train_model.py

Used for:

* Splitting the dataset
* Training the Random Forest model
* Saving the trained model

### evaluate_model.py

Used for:

* Loading the trained model
* Testing predictions
* Calculating accuracy
* Displaying confusion matrix
* Displaying classification report

### predict.py

Used for:

* Taking new sensor readings
* Loading the trained model
* Predicting machine failure

---

## Project Structure

```text
AI-Based-Predictive-Maintenance/
│
├── README.md
│
├── python-ml/
│   ├── preprocessing.py
│   ├── train_model.py
│   ├── evaluate_model.py
│   ├── predict.py
│   ├── requirements.txt
│   └── ai4i2020.csv
│
├── java-backend/
│   ├── src/
│   └── README.md
│
├── database/
│   ├── machine.sql
│   ├── sensor_data.sql
│   └── prediction_history.sql
│
└── integration/
    └── architecture.md
```

> The exact folder structure may be simplified depending on how much of the Java, Oracle, and Python integration is implemented.

---

## Installation

### 1. Clone the Repository

Clone this GitHub repository to your computer.

```bash
git clone <your-github-repository-url>
```

### 2. Install Python

Make sure Python is installed.

Check using:

```bash
python --version
```

### 3. Install Python Libraries

Navigate to the Python ML folder:

```bash
cd python-ml
```

Install the required libraries:

```bash
pip install -r requirements.txt
```

### 4. Setup Oracle Database

Create the required tables using the SQL scripts inside:

```text
database/
```

### 5. Configure Java

Open the Java project in Eclipse and configure the Oracle JDBC connection using your own database credentials.

**Do not upload real passwords or database credentials to GitHub.**

---

## Running the Machine Learning Model

### Step 1 — Preprocess the Dataset

```bash
python preprocessing.py
```

### Step 2 — Train the Model

```bash
python train_model.py
```

### Step 3 — Evaluate the Model

```bash
python evaluate_model.py
```

### Step 4 — Make a Prediction

```bash
python predict.py
```

---

## Example Output

The actual output depends on the dataset and trained model.

Example:

```text
Model Training Completed

Accuracy: XX.XX%

Prediction: No Failure
```

The exact accuracy and prediction should be added after actually running the model.

---

## Database Workflow

The overall database workflow is:

```text
Machine
   |
   v
Sensor Data
   |
   v
Oracle Database
   |
   v
Java JDBC
   |
   v
Application
   |
   v
Prediction History
```

---

## Integration

This project demonstrates a **prototype-level integration** between:

```text
Oracle SQL
    ↕
Java + JDBC
    ↕
Python Machine Learning
```

The Python component is responsible for machine learning, while Java is responsible for application and database operations.

A production system could use a REST API or another service-based architecture to connect Java and Python more directly.

---

## Current Project Scope

This is an **academic/prototype project** created to demonstrate the concepts of:

* Predictive maintenance
* Machine learning
* Industrial sensor data
* Oracle database
* Java JDBC
* Backend architecture
* Python ML integration

The project does not represent a complete industrial production system.

---

## Limitations

* No physical industrial sensors are connected.
* The project uses a public/synthetic dataset.
* The machine learning model is trained using historical data.
* Java-Python communication is demonstrated at a prototype level.
* The system is not deployed as a real-time industrial monitoring platform.
* Database and backend components are intended for academic demonstration.

---

## Future Enhancements

The project can be extended with:

* Real-time IoT sensor integration
* ESP32 or industrial sensor integration
* REST API for Java-Python communication
* Real-time prediction
* Web dashboard
* Cloud deployment
* Automated maintenance alerts
* Integration with industrial machines
* Advanced machine learning models

---

## Skills Demonstrated

Through this project, the following skills are demonstrated:

* Java Programming
* Object-Oriented Programming
* Oracle SQL
* JDBC
* DAO Pattern
* Python Programming
* NumPy
* Pandas
* Scikit-learn
* Machine Learning
* Random Forest Classification
* Model Evaluation
* Database Design
* Git & GitHub
* System Architecture

---

## Key Learning

This project demonstrates how different technologies can work together to build an AI-based industrial application:

```text
Database
   +
Java Backend
   +
Python Machine Learning
   =
Predictive Maintenance System
```

The main concept is to use historical machine sensor data to identify patterns associated with failures and use those patterns to predict potential future failures.

---

## Author

**Suhas M Bharadwaj**

B.E. Mechanical Engineering
JSS Science and Technology University, Mysuru

---

## Disclaimer

This project is developed for **academic and learning purposes**. It is a prototype demonstrating the concept of AI-based predictive maintenance and should not be used directly for safety-critical industrial decision-making.
