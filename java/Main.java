import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            // --------------------------------------------------
            // 1. Connect to Oracle Database
            // --------------------------------------------------

            connection = DBConnection.getConnection();

            System.out.println("Oracle database connected successfully.");


            // --------------------------------------------------
            // 2. Retrieve machine data
            // --------------------------------------------------

            String sql =
                    "SELECT machine_id, " +
                    "air_temperature, " +
                    "process_temperature, " +
                    "rotational_speed, " +
                    "torque, " +
                    "tool_wear " +
                    "FROM sensor_data " +
                    "WHERE machine_id = ?";


            statement = connection.prepareStatement(sql);

            statement.setInt(1, 1);

            resultSet = statement.executeQuery();


            if (resultSet.next()) {

                int machineId =
                        resultSet.getInt("machine_id");

                double airTemperature =
                        resultSet.getDouble("air_temperature");

                double processTemperature =
                        resultSet.getDouble("process_temperature");

                double rotationalSpeed =
                        resultSet.getDouble("rotational_speed");

                double torque =
                        resultSet.getDouble("torque");

                double toolWear =
                        resultSet.getDouble("tool_wear");


                // --------------------------------------------------
                // 3. Create MachineData object
                // --------------------------------------------------

                MachineData machine = new MachineData(
                        machineId,
                        airTemperature,
                        processTemperature,
                        rotationalSpeed,
                        torque,
                        toolWear
                );


                // --------------------------------------------------
                // 4. Display machine data
                // --------------------------------------------------

                System.out.println();
                System.out.println("----- Machine Data -----");

                System.out.println(
                        "Machine ID: " + machine.getMachineId());

                System.out.println(
                        "Air Temperature: "
                                + machine.getAirTemperature());

                System.out.println(
                        "Process Temperature: "
                                + machine.getProcessTemperature());

                System.out.println(
                        "Rotational Speed: "
                                + machine.getRotationalSpeed());

                System.out.println(
                        "Torque: "
                                + machine.getTorque());

                System.out.println(
                        "Tool Wear: "
                                + machine.getToolWear());

                System.out.println("------------------------");


                // --------------------------------------------------
                // 5. Call Python ML model
                // --------------------------------------------------

                String predictionResult =
                        runPythonPrediction(machine);


                // --------------------------------------------------
                // 6. Create Prediction object
                // --------------------------------------------------

                Prediction prediction =
                        new Prediction(
                                machine,
                                predictionResult
                        );


                // --------------------------------------------------
                // 7. Display prediction
                // --------------------------------------------------

                prediction.displayPrediction();

            } else {

                System.out.println(
                        "No machine data found."
                );
            }


        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

            e.printStackTrace();

        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {

                System.out.println(
                        "Error while closing resources: "
                                + e.getMessage()
                );
            }
        }
    }


    // --------------------------------------------------
    // Java → Python integration
    // --------------------------------------------------

    private static String runPythonPrediction(
            MachineData machine) throws Exception {


        ProcessBuilder processBuilder =
                new ProcessBuilder(
                        "python",
                        "python/predict.py",

                        String.valueOf(
                                machine.getAirTemperature()),

                        String.valueOf(
                                machine.getProcessTemperature()),

                        String.valueOf(
                                machine.getRotationalSpeed()),

                        String.valueOf(
                                machine.getTorque()),

                        String.valueOf(
                                machine.getToolWear())
                );


        processBuilder.redirectErrorStream(true);


        Process process =
                processBuilder.start();


        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                process.getInputStream()
                        )
                );


        StringBuilder output =
                new StringBuilder();

        String line;


        while ((line = reader.readLine()) != null) {

            output.append(line);
        }


        int exitCode =
                process.waitFor();


        if (exitCode != 0) {

            throw new RuntimeException(
                    "Python prediction process failed."
            );
        }


        return output.toString();
    }
}
