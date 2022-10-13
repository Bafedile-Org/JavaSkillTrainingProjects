package za.co.mecer.services;

import java.io.IOException;
import java.sql.SQLException;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorService {

    public void processAuthorMenu(int choice) throws SQLException, AuthorException, IOException;

    public String getAuthorName() throws IOException;

    public int getAuthorId();

    public String getAuthorBookISBN();

    public Author getAuthorDetails() throws AuthorException, SQLException, IOException;
}
