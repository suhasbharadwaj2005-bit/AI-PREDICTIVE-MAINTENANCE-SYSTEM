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
