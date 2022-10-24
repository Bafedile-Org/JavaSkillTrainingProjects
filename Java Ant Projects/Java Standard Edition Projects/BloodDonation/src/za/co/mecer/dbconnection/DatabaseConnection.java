package za.co.mecer.dbconnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import za.co.mecer.bloodbank.BloodBank;
import za.co.mecer.donor.Donor;
import za.co.mecer.patient.Patient;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DatabaseConnection {

    private static Connection conn;
    private PreparedStatement preparedStatement;
    private static DatabaseConnection dbConn;
    private static String databaseName = "blood_donation_db";

    private DatabaseConnection() {
        String url, user, pass;
        try (InputStream stream = new FileInputStream(new File("database.properties"))) {
            Properties properties = new Properties();
            properties.load(stream);

            url = properties.getProperty("url");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");
            conn = DriverManager.getConnection(url, user, pass);
            createDatabase(conn);
            conn.prepareStatement("USE " + databaseName).executeUpdate();

        } catch (IOException | SQLException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    static {
        dbConn = new DatabaseConnection();
    }

    public Connection getConnection() {
        return conn;
    }

    public static DatabaseConnection getInstance() {
        return dbConn;
    }

    private static void createDatabase(Connection conn) throws SQLException {
        conn.prepareStatement("CREATE DATABASE IF NOT EXISTS blood_donation_db;\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS patient (patient_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25) NOT NULL, \n"
                + "blood_group_id INT NOT NULL , disease VARCHAR(60),FOREIGN KEY(blood_group_id) REFERENCES blood_group(blood_id));\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS blood_group (blood_id INT AUTO_INCREMENT PRIMARY KEY, blood_type VARCHAR(2));\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS donor(donor_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25) NOT NULL, blood_group_id INT NOT NULL, \n"
                + "medical_report VARCHAR (255), FOREIGN KEY(blood_group_id) REFERENCES blood_group(blood_id));\n"
                + "\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS blood_bank (bank_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25) NOT NULL,\n"
                + "address VARCHAR(60), donor_id INT NOT NULL, contact_no VARCHAR(10));");
    }

    public void close() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    public void closeResultSet(ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }
}
