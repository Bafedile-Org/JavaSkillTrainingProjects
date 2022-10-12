package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.model.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClientDAO {

    void addClient(Client client);

    public void getAllClients();

    void removeClient(String identityNum);

    void changeClientAddress(String identityNum, String newAddress);

    void changeClientHomeTel(String identityNum, String newHomeTel);

    void changeClientWorkTel(String identityNum, String newWorkTel);

    void changeClientMobileTel(String identityNum, String newMobileTel);

    Client searchClient(String identityNum);

    public void close(PreparedStatement preparedStatement, ResultSet result);

    public void displayClients();
}
