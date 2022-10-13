package za.co.mecer.model.test;

import java.sql.SQLException;
import za.co.mecer.model.Author;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorTest {

    public AuthorTest() {
    }

    @Test
    public void assertSetNameNotNull() {
        try {
            Author author = new Author("Dimakatso");
            assertNotNull(author.getName());
        } catch (AuthorException | SQLException ex) {

        }
    }

    @Test
    public void assertSetNameThrows() {
        Author author;
        try {
            author = new Author("Dimakatso");
            assertNotNull(author.getName());
        } catch (AuthorException | SQLException ex) {

        }

        AuthorException ex = assertThrows(AuthorException.class, () -> author.setName(null));
    }
}
