package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.dao.AuthorBookDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.impl.AuthorBookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorBookDAOTest {

    static Connection conn;
    static AuthorBookDAO authorBook;
    static ClosingDAO close;

    public AuthorBookDAOTest() {
    }

    @BeforeAll
    public static void setUp() {
        conn = DatabaseConnection.getInstance().getConnection();
        authorBook = new AuthorBookDAOImpl(conn);
        authorBook.addAuthorBook(1, 1);
    }

    @AfterAll
    public static void closeUp() {
        authorBook.removeAuthorBook(1, 1);
    }

    @Test
    public void assertGetBookIsbnNull() {
        assertNull(authorBook.getBookIsbn(1));
    }

}
