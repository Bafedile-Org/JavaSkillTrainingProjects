package za.co.mecer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.client.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClientDAO {

    void addClient(Client client) throws SQLException;

    public ResultSet getAllClients() throws SQLException;

    void removeClient(String identityNum) throws SQLException;

    void changeClientAddress(String identityNum, String newAddress) throws SQLException;

    void changeClientHomeTel(String identityNum, String newHomeTel) throws SQLException;

    void changeClientWorkTel(String identityNum, String newWorkTel) throws SQLException;

    void changeClientMobileTel(String identityNum, String newMobileTel) throws SQLException;

    ResultSet searchClient(String identityNum) throws SQLException;
}
