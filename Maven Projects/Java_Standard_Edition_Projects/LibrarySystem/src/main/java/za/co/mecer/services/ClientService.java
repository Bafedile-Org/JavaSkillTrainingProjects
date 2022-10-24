package za.co.mecer.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.model.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ClientService {

    public void processClientMenu(int choice) throws SQLException, ClientException, IOException;

    public Client getClientDetails() throws ClientException, IOException;

    public String getTelephone(String str);

    public String getClientIdentity();

    public String getAddress() throws IOException;

    public void displayClient(ResultSet set) throws SQLException;
}
