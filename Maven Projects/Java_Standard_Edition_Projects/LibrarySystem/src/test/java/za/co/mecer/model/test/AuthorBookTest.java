package za.co.mecer.model.test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.AuthorBook;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorBookTest {

    static AuthorBook authorBook;

    public AuthorBookTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            authorBook = new AuthorBook(1, 2);
        } catch (AuthorException | BookException | SQLException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void setBookIdThrows() {
        assertThrows(BookException.class, () -> authorBook.setBookId(0));
    }

    @Test
    public void setAuthorIdThrows() {
        assertThrows(AuthorException.class, () -> authorBook.setAuthorId(0));
    }

    @Test
    public void assertGetAuthorId() {
        assertTrue(authorBook.getAuthorId() > 0);
    }

    @Test
    public void assertGetBookId() {
        assertTrue(authorBook.getBookId() > 0);
    }
}
