package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.impl.AuthorDAOImpl;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Author;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookDAOTest {

    static BookDAO bookDao;
    static Connection conn;
    static int bookId;

    public BookDAOTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            bookDao = new BookDAOImpl(conn);
            bookDao.addBook(new Book("Inferno", "1234567890124", true, true));
            bookId = bookDao.getBookId("1234567890124");
        } catch (SQLException | BookException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @AfterAll
    public static void closeUp() {
        bookDao.removeBook("1234567890124");
    }

    @Test
    public void assertSearchBookNotNull() {
        assertNotNull(bookDao.searchBook("1234567890124"));
    }

    @Test
    public void assertSearchBookNull() {
        assertNull(bookDao.searchBook("1234567890125"));
    }

    @Test
    public void assertGetBookIdNotZero() {
        assertTrue(bookId > 0);
    }

    @Test
    public void assertGetBookIdZero() {
        assertFalse(bookDao.getBookId("1234456789012") > 0);
    }

}
