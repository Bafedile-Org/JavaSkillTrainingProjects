package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.impl.AuthorDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorDAOTest {

    static AuthorDAO authorDao;
    static Connection conn;
    static PreparedStatement preparedStatement;
    static ResultSet result;
    static ClosingDAO close;
    static int authorId;

    public AuthorDAOTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            authorDao = new AuthorDAOImpl(conn);
            authorDao.addAuthor(new Author("Dan Brown"));
            authorId = authorDao.getAuthorId("Dan Brown");
        } catch (AuthorException | SQLException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @AfterAll
    public static void closeUp() {
        try {
            authorDao.removeAuthor(authorId);
            close.close(preparedStatement, result);
        } catch (NullPointerException ex) {

        }
    }

    @Test
    public void assertGetAuthorIdNotZero() {
        assertTrue(authorDao.getAuthorId("Dan Brown") > 0);
    }

    @Test
    public void assertGetAuthorNameNotNull() {
        assertNotNull(authorDao.getAuthorName(authorId));
    }

    @Test
    public void assertGetAuthorNameNull() {
        assertNull(authorDao.getAuthorName(0));
    }

    @Test
    public void assertSearchAuthorNotNull() {
        assertNotNull(authorDao.searchAuthor("Dan Brown"));
    }

    @Test
    public void assertSearchAuthorNull() {
        assertNull(authorDao.searchAuthor("Dan Browns"));
    }

}
