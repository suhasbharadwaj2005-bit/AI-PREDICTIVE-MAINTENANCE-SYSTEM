import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    // Replace these with your own Oracle details.
    private static final String USERNAME =
            "your_username";

    private static final String PASSWORD =
            "your_password";

    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            System.out.println(
                    "Oracle database connected successfully."
            );

            return connection;

        } catch (SQLException e) {

            System.out.println(
                    "Database connection failed."
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );

            return null;
        }
    }
}
