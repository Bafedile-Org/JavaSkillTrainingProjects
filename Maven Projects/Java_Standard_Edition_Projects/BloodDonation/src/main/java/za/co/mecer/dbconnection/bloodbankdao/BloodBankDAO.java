package za.co.mecer.dbconnection.bloodbankdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.co.mecer.bloodbank.BloodBank;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BloodBankDAO {

    private PreparedStatement preparedStatement;
    private Connection conn;

    public BloodBankDAO(Connection conn) {
        this.conn = conn;
    }

    public void addBloodBank(BloodBank bloodBank) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO blood_bank (name,address,donor_id, contact_no) VALUES"
                    + "(?,?,?,?);");
            preparedStatement.setString(1, bloodBank.getName());
            preparedStatement.setString(2, bloodBank.getAddress());
            preparedStatement.setInt(3, bloodBank.getDonorId());
            preparedStatement.setString(4, bloodBank.getContactNum());
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    public void removeBloodBank(BloodBank bloodBank) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM blood_bank WHERE name =? AND donor_id = ? AND contact_no = ? ; ");
            preparedStatement.setString(1, bloodBank.getName());
            preparedStatement.setInt(2, bloodBank.getDonorId());
            preparedStatement.setString(3, bloodBank.getContactNum());
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }
}
