package za.co.mecer.model.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookTest {

    static Book book;

    public BookTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            book = new Book(1, "inferno", "1234567890123", true, false);
        } catch (BookException ex) {
            System.out.println(String.format("Error: %s%", ex.getMessage()));
        }
    }

    @Test
    public void assertSetIsbnThrows() {
        assertThrows(BookException.class, () -> book.setISBN("1234567"));
    }

    @Test
    public void assertSetBookIdThrows() {
        assertThrows(BookException.class, () -> book.setBookId(0));
    }

    @Test
    public void assertCheckIsbnTrue() {
        assertTrue(book.checkISBN("1234567890123"));
    }

    @Test
    public void assertCheckIsbnFalse() {
        assertFalse(book.checkISBN("123456"));
    }

    @Test
    public void assertGetBookIdNotZero() {
        assertTrue(book.getBookId() > 0);
    }

    @Test
    public void assertGetIsbnNotNull() {
        assertNotNull(book.getISBN());
    }

    @Test
    public void assertGetAvailabilityTrue() {
        book.setAvailability(true);
        assertTrue(book.getAvailability());
    }

    @Test
    public void assertGetAccessibilityTrue() {
        book.setAccess(true);
        assertTrue(book.getAccess());
    }
}
