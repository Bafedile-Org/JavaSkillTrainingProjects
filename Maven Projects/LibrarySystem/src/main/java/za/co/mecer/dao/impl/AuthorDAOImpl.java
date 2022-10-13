package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorDAOImpl implements AuthorDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Connection conn = null;
    private AuthorBookDAOImpl authorBookImpl;
    List<Author> authors = new ArrayList<>();

    public AuthorDAOImpl(Connection conn) {
        this.conn = conn;
        this.authorBookImpl = new AuthorBookDAOImpl(conn);
    }

    @Override
    public void addAuthor(Author author) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO author (name) VALUES (?)");
                preparedStatement.setString(1, author.getName());
                preparedStatement.executeUpdate();

            }

        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage() + "\n");
//            se.printStackTrace();
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void removeAuthor(int authorId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM author WHERE author_id = ?");
                preparedStatement.setInt(1, authorId);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    public int getAuthorId(String name) {
        Author author = searchAuthor(name);
        int authorId = author.getAuthorId();
        return authorId;
    }

    //**********************************************************************************
    @Override
    public Author searchAuthor(String name) {
        Author author = null;
        authors.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM author WHERE name = ? ");
                preparedStatement.setString(1, name);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    author = new Author(result.getInt("author_id"), result.getString("name"));
                    authors.add(author);
                }
            }
        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

        return author;
    }

    //**********************************************************************************
    @Override
    public void getAllAuthors() {

        Author author = null;
        authors.clear();

        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM author");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    author = new Author(result.getInt("author_id"), result.getString("name"));
                    authors.add(author);
                }

            }
        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

    }

    @Override
    public void displayAuthors() {
        authors.forEach((author) -> System.out.println(author));
    }

    @Override
    public void close(PreparedStatement preparedStatement, ResultSet result) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
    }

}
