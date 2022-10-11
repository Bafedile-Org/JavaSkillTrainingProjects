package za.co.mecer.author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.author.Author;
import za.co.mecer.impl.dao.AuthorDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorDAOImpl implements AuthorDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    private Author author;
    Connection conn = null;

    public AuthorDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO author (name) VALUES (?)");
        preparedStatement.setString(1, author.getName());
        preparedStatement.executeUpdate();

        preparedStatement = conn.prepareStatement("INSERT INTO author_book (author_id, book_id) VALUES ("
                + "(SELECT author_id FROM author WHERE name = ? ),(SELECT book_id FROM book WHERE isbn=?))");
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getBookISBN());
        preparedStatement.executeUpdate();

    }

    @Override
    public void removeAuthor(Author author) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE  FROM author_book WHERE author_id = (SELECT author_id FROM author WHERE name = ?) AND book_id = ?");
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getBookISBN());
        preparedStatement.executeUpdate();

    }

    @Override
    public Author searchAuthor(String name) throws SQLException {
        Author author = null;
        preparedStatement = conn.prepareStatement("SELECT * FROM author_book WHERE author_id = (SELECT author_id FROM author WHERE name = ?) ");
        preparedStatement.setString(1, author.getName());
        result = preparedStatement.executeQuery();
        if (result.next()) {
            author = new Author();

        }

        return result;
    }

    @Override
    public ResultSet getAllAuthors() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM author_book");
        result = preparedStatement.executeQuery();
        return result;
    }

}
