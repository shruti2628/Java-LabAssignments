package traineeManagement.trainee.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectionFactory {
	private static final Properties properties = new Properties();

    static {
        try (InputStream input = JdbcConnectionFactory.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            properties.load(input);

            Class.forName(properties.getProperty("jdbc.driver"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize JDBC Connection Factory", e);
        }
    }

    private JdbcConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"),
                properties.getProperty("jdbc.password")
        );
    }
}
