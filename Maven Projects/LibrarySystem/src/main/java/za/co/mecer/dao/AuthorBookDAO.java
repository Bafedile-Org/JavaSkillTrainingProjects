package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBookDAO {

    public void addAuthorBook(int authorId, int bookId);

    public void removeAuthorBook(int authorId, int bookId);

    public void close(PreparedStatement preparedStatement, ResultSet result);

}
