package za.co.mecer.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DatabaseConnection {

    private static DatabaseConnection dbConn = null;
    private static PreparedStatement preparedStatement = null;
    private static Connection conn = null;

    private DatabaseConnection() throws SQLException {

    }

    private static void connect() throws SQLException {
        String user, url, pass;
        try (InputStream stream = new FileInputStream("database.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }
}
