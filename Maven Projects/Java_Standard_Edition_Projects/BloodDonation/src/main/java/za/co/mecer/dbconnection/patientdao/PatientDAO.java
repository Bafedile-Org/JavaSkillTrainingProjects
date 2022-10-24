package za.co.mecer.dbconnection.patientdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.patient.Patient;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PatientDAO {

    private Connection conn;

    public PatientDAO(Connection conn) {
        this.conn = conn;
    }
    private PreparedStatement preparedStatement;

    public void addPatient(Patient patient) throws SQLException {
        /**
         * <<Patient Fields>> patient_id, name, blood_group_id,disease
         */
        preparedStatement = conn.prepareStatement("INSERT INTO patient(name,blood_group_id,disease) VALUES (?, ?, ?);");
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setInt(2, patient.getBloodGroupId());
        preparedStatement.setString(3, patient.getDisease());
        preparedStatement.executeUpdate();
    }

    public void removePatient(Patient patient) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM patient WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setInt(2, patient.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public void updatePatientName(Patient patient, String newName) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE patient SET name =? WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, patient.getName());
        preparedStatement.setInt(3, patient.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public void updatePatientDisease(Patient patient, String newDiag) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE patient SET disease =? WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setString(1, newDiag);
        preparedStatement.setString(2, patient.getName());
        preparedStatement.setInt(3, patient.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public void updatePatientBloodId(Patient patient, int bloodId) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE patient SET blood_group_id ='?' WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setInt(bloodId, bloodId);
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setInt(2, patient.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public ResultSet getPatient(String name, int bloodGroupId) throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM patient WHERE name = ? AND blood_group_id = ?;");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, bloodGroupId);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

    public ResultSet getAllPatients() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM patient;");
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

}
