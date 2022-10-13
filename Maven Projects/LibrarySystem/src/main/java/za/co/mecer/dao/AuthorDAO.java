package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorDAO {

    public void addAuthor(Author author);

    public void removeAuthor(int authorId);

    public Author searchAuthor(String name);

    public void getAllAuthors();

    public void displayAuthors();

    public void close(PreparedStatement preparedStatement, ResultSet result);

}
