package za.co.mecer.model.test;

import java.sql.SQLException;
import za.co.mecer.model.Author;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorTest {

    static Author author;

    /**
     * Remember you did not run tests for the author get book method Fix it
     */
    @BeforeAll
    public static void setUp() {
        try {
            author = new Author(2, "stuart");
        } catch (AuthorException | SQLException ex) {

        }
    }

    public AuthorTest() {
    }

    @Test
    public void assertSetNameNotNull() {
        assertNotNull(author.getName());

    }

    @Test
    public void assertSetAuthorNameThrows() {
        AuthorException ex = assertThrows(AuthorException.class,
                () -> author.setName(""));
    }

    @Test
    public void assertSetAuthorIdThrows() {
        AuthorException ex = assertThrows(AuthorException.class,
                () -> author.setAuthorId(0));
    }

    @Test
    public void assertGetAuthorNameNotNull() {
        assertNotNull(author.getName());
    }

    @Test
    public void assertGetAuthorBookNull() {
        assertNull(author.getAuthorBook());
    }

    @Test
    public void assertGetAuthorIdNotZero() {
        assertNotEquals(0, author.getAuthorId());
    }
}
