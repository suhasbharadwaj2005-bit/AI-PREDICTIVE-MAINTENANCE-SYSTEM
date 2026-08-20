# AI-Based Predictive Maintenance System for Industrial Machines

## Project Description
A machine learning–based predictive maintenance system that analyzes industrial machine sensor data (air temperature, process temperature, rotational speed, torque, tool wear) to predict potential equipment failures before they occur. The system integrates a Python-based ML model with a Java backend and an Oracle SQL database to simulate a real-world Computerized Maintenance Management System (CMMS) workflow.

## Problem Statement
Unplanned industrial machine failures lead to costly downtime, safety risks, and inefficient maintenance scheduling. Traditional maintenance is either reactive (fix after failure) or purely time-based (fixed schedules), both of which are inefficient. Predictive maintenance uses sensor data and machine learning to anticipate failures before they happen.

## Objective
To design and implement a predictive maintenance pipeline that:
- Stores machine and sensor data in a relational database (Oracle SQL)
- Processes and analyzes historical sensor data using Python and Scikit-learn
- Trains a classification model (Random Forest) to predict machine failure
- Connects the Java backend to the database using JDBC
- Demonstrates an end-to-end architecture connecting data storage, ML prediction, and application logic

## Features
- Machine and sensor data management (CRUD operations via Java + JDBC)
- Data preprocessing pipeline for the AI4I 2020 Predictive Maintenance dataset
- Random Forest classification model to predict machine failure
- Model evaluation using accuracy, confusion matrix, and classification report
- Prediction script for new/unseen sensor readings
- Documented architecture connecting Java, Oracle SQL, and Python ML components

## Technologies Used
- **Backend:** Java (OOP, JDBC)
- **Database:** Oracle SQL
- **Machine Learning:** Python, NumPy, Pandas, Scikit-learn
- **Version Control:** Git & GitHub

## Architecture


## Workflow
1. Sensor data is recorded and stored in the Oracle database via the Java backend.
2. Python scripts read historical data, preprocess it, and train a Random Forest classifier.
3. The trained model is used to generate predictions on new sensor readings.
4. Predictions are stored back into the database via the Java backend for record-keeping.

## Dataset
This project uses the **AI4I 2020 Predictive Maintenance Dataset**, which contains synthetic but realistic industrial sensor readings and failure labels, including air temperature, process temperature, rotational speed, torque, and tool wear.

## Machine Learning Workflow
- Data loading and cleaning (`preprocessing.py`)
- Train-test split
- Model training using Random Forest Classifier (`train_model.py`)
- Model evaluation using accuracy, confusion matrix, and classification report (`evaluate_model.py`)
- Prediction on new data (`predict.py`)

## Oracle Database
Three core tables:
- `MACHINE` — stores machine details
- `SENSOR_DATA` — stores sensor readings per machine
- `PREDICTION_HISTORY` — stores model predictions over time

## Java / JDBC
The Java backend uses JDBC to connect to the Oracle database, following a DAO (Data Access Object) pattern for clean separation between database logic and business logic.

## Python ML
Python scripts handle data preprocessing, model training, evaluation, and prediction using Pandas, NumPy, and Scikit-learn.

## Integration
This project demonstrates a **prototype-level integration** between the Java backend and the Python ML model. See `integration/architecture.md` for details on what is implemented versus what would be required for full production-level integration.

## Project Structure

## Installation
1. Clone this repository.
2. Set up the Oracle database using the scripts in `database/`.
3. Install Python dependencies: `pip install -r python-ml/requirements.txt`
4. Configure database credentials (see `java-backend/README.md`) using your own local values — never commit real credentials.
5. Compile and run the Java backend using your preferred IDE (e.g., Eclipse).

## Running Instructions
- Run `train_model.py` first to train and save the ML model.
- Run `predict.py` to generate predictions on new sensor data.
- Run the Java backend application to manage machine/sensor records and view stored predictions.

## Example Prediction
*(To be filled in after running the trained model — depends on actual model output.)*

## Model Evaluation
*(To be filled in with actual accuracy, confusion matrix, and classification report output after training.)*

## Limitations
- This is an academic/demo project, not a production industrial system.
- No real physical sensors are connected; data is sourced from a public dataset.
- Java–Python integration is a prototype-level demonstration, not a real-time production pipeline.

## Future Enhancements
- Real-time sensor data ingestion
- Deployment as a REST API
- Dashboard for visualization of predictions
- Integration with real industrial IoT devices

## Skills Demonstrated
- Object-Oriented Programming (Java)
- Relational database design (Oracle SQL)
- JDBC and DAO pattern
- Data preprocessing and machine learning (Python, Scikit-learn)
- Model evaluation techniques
- End-to-end system architecture design
- Git and GitHub version control

## Author
Suhas M Bharadwaj
B.E. Mechanical Engineering, JSS Science and Technology University, Mysuru
