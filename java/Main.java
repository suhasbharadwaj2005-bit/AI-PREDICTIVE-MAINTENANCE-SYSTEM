import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Connection connection =
                DBConnection.getConnection();

        if (connection == null) {

            System.out.println(
                    "Application stopped because "
                    + "database connection failed."
            );

            return;
        }

        String query =
                "SELECT machine_id, "
                + "air_temperature, "
                + "process_temperature, "
                + "rotational_speed, "
                + "torque, "
                + "tool_wear "
                + "FROM machine_sensor_data "
                + "ORDER BY reading_id";

        try {

            PreparedStatement statement =
                    connection.prepareStatement(query);

            ResultSet resultSet =
                    statement.executeQuery();

            System.out.println(
                    "\n--- Machine Sensor Data ---"
            );

            while (resultSet.next()) {

                MachineData machineData =
                        new MachineData(
                                resultSet.getInt("machine_id"),
                                resultSet.getDouble(
                                        "air_temperature"
                                ),
                                resultSet.getDouble(
                                        "process_temperature"
                                ),
                                resultSet.getDouble(
                                        "rotational_speed"
                                ),
                                resultSet.getDouble(
                                        "torque"
                                ),
                                resultSet.getDouble(
                                        "tool_wear"
                                )
                        );

                machineData.displayData();

                System.out.println(
                        "---------------------------"
                );
            }

            resultSet.close();
            statement.close();

            System.out.println(
                    "\nJava successfully retrieved "
                    + "machine data using JDBC."
            );

            System.out.println(
                    "Python Random Forest prediction "
                    + "is handled separately."
            );

            System.out.println(
                    "Direct Java-Python integration "
                    + "can be added in a future version."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error while retrieving data."
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {

                connection.close();

                System.out.println(
                        "Database connection closed."
                );

            } catch (SQLException e) {

                System.out.println(
                        "Error while closing connection."
                );
            }
        }
    }
}
