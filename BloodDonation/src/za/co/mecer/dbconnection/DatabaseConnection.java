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
            conn.prepareStatement(String.format("USE %s", databaseName)).executeUpdate();

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

    public void addPatient(Patient patient) throws SQLException {
        /**
         * <<Patient Fields>> patient_id, name, blood_group_id,disease
         */
        preparedStatement = conn.prepareStatement(String.format("INSERT INTO patient(name,blood_group_id,disease) VALUES ('%s', %d, '%s');",
                patient.getName(), patient.getBloodGroupId(), patient.getDisease()));
        preparedStatement.executeUpdate();
    }

    public void removePatient(Patient patient) throws SQLException {
        preparedStatement = conn.prepareStatement(String.format("DELETE FROM patient WHERE name='%s' AND blood_group_id = %d;",
                patient.getName(), patient.getBloodGroupId()));
        preparedStatement.executeUpdate();
    }

    public void updatePatientName(Patient patient, String newName) throws SQLException {
        preparedStatement = conn.prepareStatement(String.format("UPDATE patient SET name ='%s' WHERE name='%s' AND blood_group_id = %d;",
                newName, patient.getName(), patient.getBloodGroupId()));
        preparedStatement.executeUpdate();
    }

    public void updatePatientDisease(Patient patient, String newDiag) throws SQLException {
        preparedStatement = conn.prepareStatement(String.format("UPDATE patient SET disease ='%s' WHERE name='%s' AND blood_group_id = %d;",
                newDiag, patient.getName(), patient.getBloodGroupId()));
        preparedStatement.executeUpdate();
    }

    public void updatePatientBloodId(Patient patient, int bloodId) throws SQLException {
        preparedStatement = conn.prepareStatement(String.format("UPDATE patient SET blood_group_id ='%d' WHERE name='%s' AND blood_group_id = %d;",
                bloodId, patient.getName(), patient.getBloodGroupId()));
        preparedStatement.executeUpdate();
    }

    public ResultSet getAllPatients() throws SQLException {
        preparedStatement = conn.prepareStatement(String.format("SELECT * FROM patient;"));
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

}
