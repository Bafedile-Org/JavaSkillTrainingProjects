package za.co.mecer.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.impl.ClientDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientDAOImpl implements ClientDAO {

    private PreparedStatement preparedStatement = null;
    private Connection conn = null;

    public ClientDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addClient(Client client) throws SQLException {
        /**
         * <<Client Fields>> firstname, lastname, identity, address, hometel, worktel,mobiletel
         */
        preparedStatement = conn.prepareStatement("INSERT INTO book (firstname,lastname,identitynum,address,"
                + " hometel, worktel, mobiletel) VALUES"
                + "(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getLastName());
        preparedStatement.setString(3, client.getIdentityNum());
        preparedStatement.setString(4, client.getAddress());
        preparedStatement.setString(5, client.getHomeTel());
        preparedStatement.setString(6, client.getWorkTel());
        preparedStatement.setString(7, client.getMobileTel());
        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void removeClient(String identityNum) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM client WHERE identitynum = ?");
        preparedStatement.setString(1, identityNum);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeClientAddress(String identityNum, String newAddress) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE client SET address=?  WHERE identitynum = ?");
        preparedStatement.setString(1, newAddress);
        preparedStatement.setString(2, identityNum);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeClientHomeTel(String identityNum, String newHomeTel) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE client SET hometel=?  WHERE identitynum = ?");
        preparedStatement.setString(1, newHomeTel);
        preparedStatement.setString(2, identityNum);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeClientWorkTel(String identityNum, String newWorkTel) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE client SET workTel=?  WHERE identitynum = ?");
        preparedStatement.setString(1, newWorkTel);
        preparedStatement.setString(2, identityNum);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeClientMobileTel(String identityNum, String newMobileTel) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE client SET mobiletel=?  WHERE identitynum = ?");
        preparedStatement.setString(1, newMobileTel);
        preparedStatement.setString(2, identityNum);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public ResultSet searchClient(String identityNum) throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM client WHERE identitynum =?");
        preparedStatement.setString(1, identityNum);
        ResultSet result = preparedStatement.executeQuery();
        preparedStatement.close();

        return result;
    }

}
