package za.co.mecer.dbconnection.donordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.donor.Donor;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DonorDAO {

    /**
     * Remember to close the prepared statement every time you finish executing a prepared statement query
     */
    private Connection conn;
    private PreparedStatement preparedStatement;

    public DonorDAO(Connection conn) {
        this.conn = conn;
    }

    public void addDonor(Donor donor) throws SQLException {

        /**
         * <<Donor Fields>> donor_id,name, blood_group_id, medical_report
         */
        preparedStatement = conn.prepareStatement("INSERT INTO donor (name, blood_group_id, medical_report) VALUES (?,?,?);");
        preparedStatement.setString(1, donor.getName());
        preparedStatement.setInt(2, donor.getBloodGroupId());
        preparedStatement.setString(3, donor.getMedicalReport());
        preparedStatement.executeUpdate();
    }

    public boolean removeDonor(Donor donor) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM donor WHERE name = ? AND blood_group_id = ?;");
        preparedStatement.setString(1, donor.getName());
        preparedStatement.setInt(2, donor.getBloodGroupId());
        return preparedStatement.executeUpdate() > 0;
    }

    public void updateDonorName(Donor donor, String newName) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE donor SET name =? WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, donor.getName());
        preparedStatement.setInt(3, donor.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public void updateDonorBloodId(Donor donor, int bloodId) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE donor SET blood_group_id ='?' WHERE name=? AND blood_group_id = ?;");
        preparedStatement.setInt(1, bloodId);
        preparedStatement.setString(2, donor.getName());
        preparedStatement.setInt(3, donor.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public void updateDonorMedicalReport(Donor donor, String medicalReport) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE donor SET medical_report = ? WHERE name = ? AND blood_group_id = ?;");
        preparedStatement.setString(1, medicalReport);
        preparedStatement.setString(2, donor.getName());
        preparedStatement.setInt(3, donor.getBloodGroupId());
        preparedStatement.executeUpdate();
    }

    public ResultSet getAllDonors() throws SQLException {
        preparedStatement = conn.prepareCall("SELECT * FROM donor;");
        return preparedStatement.executeQuery();
    }

    public ResultSet getDonor(String name, int bloodGroupId) throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM donor WHERE name = ? AND blood_group_id = ?;");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, bloodGroupId);
        return preparedStatement.executeQuery();
    }
}
