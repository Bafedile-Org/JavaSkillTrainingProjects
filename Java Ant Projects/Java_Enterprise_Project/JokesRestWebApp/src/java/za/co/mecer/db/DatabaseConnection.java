package za.co.mecer.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DatabaseConnection {

    private static DatabaseConnection dbCon;
    private static Connection conn;

    private DatabaseConnection() {
        connect();
    }

    static {
        dbCon = new DatabaseConnection();

    }

    public static DatabaseConnection getInstance() {
        return dbCon;
    }

    public Connection getConnection() {
        connect();
        return conn;
    }

    private void connect() {
        try (InputStream stream = new FileInputStream(new File("C:\\JavaProgs\\JavaSkillTrainingProjects\\Java Ant Projects"
                + "\\Java_Enterprise_Project\\JokesWebApp\\web\\assets\\database.properties"))) {
            Properties properties = new Properties();
            properties.load(stream);
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");

            conn = DriverManager.getConnection(url, username, password);
            createDatabase(conn);
        } catch (IOException | SQLException iox) {
            System.out.println(iox);

        }
    }

    private static void createDatabase(Connection conn) throws SQLException {

        conn.prepareStatement("CREATE DATABASE IF NOT EXISTS  jokes_db").executeUpdate();
        conn.prepareStatement("USE jokes_db").executeUpdate();
        conn.prepareStatement("CREATE TABLE IF NOT EXISTS  jokes (cat VARCHAR(20) ,joke VARCHAR(255),PRIMARY KEY(cat,joke) );").executeUpdate();

    }

}
