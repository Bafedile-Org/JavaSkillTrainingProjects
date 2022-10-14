package za.co.mecer.model.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.dao.ClientDAO;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.model.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientTest {

    static Client client1, client2;
    static ClientDAO clientDao;

    public ClientTest() {
    }

    @BeforeAll
    public static void startUp() {
        clientDao = new ClientDAOImpl(DatabaseConnection.getInstance().getConnection());
        client1 = clientDao.searchClient("1234567890123");
        client2 = new Client();
    }

    @Test
    public void assertSetFirstNameThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setFirstName(""));
    }

}
