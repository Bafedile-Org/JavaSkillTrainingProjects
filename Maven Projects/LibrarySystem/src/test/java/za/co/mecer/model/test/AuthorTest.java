package za.co.mecer.model.test;

import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorTest {

    static Author author;

    @BeforeAll
    public static void setUp() {
        try {
            author = new Author(2, "stuart");
        } catch (AuthorException | SQLException ex) {

        }
    }

    @AfterAll
    public static void closeUp() {
        author = null;
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
    public void assertGetAuthorIdNotZero() {
        assertNotEquals(0, author.getAuthorId());
    }

}
