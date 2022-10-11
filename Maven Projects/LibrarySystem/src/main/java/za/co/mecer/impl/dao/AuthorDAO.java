package za.co.mecer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.author.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorDAO {

    public void addAuthor(Author author) throws SQLException;

    public void removeAuthor(Author author) throws SQLException;

    public ResultSet searchAuthor(String name) throws SQLException;

    public ResultSet getAllAuthors() throws SQLException;

}
