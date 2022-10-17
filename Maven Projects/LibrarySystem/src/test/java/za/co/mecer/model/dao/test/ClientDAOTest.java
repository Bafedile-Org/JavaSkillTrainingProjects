package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.dao.ClientDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.model.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientDAOTest {

    public ClientDAOTest() {
    }

    static ClientDAO clientDao;
    static Connection conn;

    @BeforeAll
    public static void setUp() {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            clientDao = new ClientDAOImpl(conn);
            clientDao.addClient(new Client("Dan", "Brown", "1234567890124", "England, London", "0123456789", "", ""));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @AfterAll
    public static void closeUp() {
        clientDao.removeClient("1234567890124");
    }

    @Test
    public void assertSearchClientNotNull() {
        assertNotNull(clientDao.searchClient("1234567890124"));
    }

    @Test
    public void assertSearchClientNull() {
        assertNull(clientDao.searchClient("1234567890125"));
    }
}
