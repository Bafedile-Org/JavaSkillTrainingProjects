package za.co.mecer.model;

import java.sql.SQLException;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.Authors;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Author implements Authors {

    private String name, isbn;
    private int authorId;

    private BookDAO bookDao;

    public Author(int authorId) throws SQLException {
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    public Author(int authorId, String name) throws AuthorException, SQLException {
        this.setName(name);
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    public Author(String name) throws AuthorException, SQLException {
        this.setName(name);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Author Name: %s%n"
                + "Author Id: %d%n"
                + "Book ISBN Number: %s%n%s%n%n", name, authorId, isbn, getAuthorBook());
    }

    @Override
    public int getAuthorId() {
        return authorId;
    }

    @Override
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public Book getAuthorBook() {
        Book book = bookDao.searchBook(isbn);
        return book;
    }
}
