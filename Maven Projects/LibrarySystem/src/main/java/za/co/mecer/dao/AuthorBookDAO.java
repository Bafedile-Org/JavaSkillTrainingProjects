package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBookDAO {

    public void addAuthorBook(int authorId, int bookId);

    public void removeAuthorBook(int authorId, int bookId);

}
