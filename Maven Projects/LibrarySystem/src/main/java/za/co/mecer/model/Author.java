package za.co.mecer.model;

import java.sql.SQLException;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.Authors;
import za.co.mecer.dao.AuthorBookDAO;
import za.co.mecer.dao.impl.AuthorBookDAOImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Author implements Authors {

    private String name, isbn;
    private int authorId;

    private BookDAO bookDao;
    private AuthorBookDAO authorBookDao;

    /**
     *
     * @param authorId
     * @throws SQLException
     */
    public Author(int authorId) throws SQLException, AuthorException {
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    /**
     *
     * @param authorId
     * @param name
     * @throws AuthorException
     * @throws SQLException
     */
    public Author(int authorId, String name) throws AuthorException, SQLException {
        this.setName(name);
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    /**
     *
     * @param name
     * @throws AuthorException
     * @throws SQLException
     */
    public Author(String name) throws AuthorException, SQLException {
        this.setName(name);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    /**
     *
     * @param name
     * @throws za.co.mecer.exceptions.AuthorException
     */
    @Override
    public void setName(String name) throws AuthorException {
        if (name.length() <= 0) {
            throw new AuthorException(NAME_ERROR_MSG);
        }
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Author Name: %s%n"
                + "Author Id: %d%n"
                + "Book ISBN Number: %s%n%s%n%n", name, authorId, isbn, getAuthorBook());
    }

    /**
     *
     * @return
     */
    @Override
    public int getAuthorId() {
        return authorId;
    }

    /**
     *
     * @param authorId
     */
    @Override
    public void setAuthorId(int authorId) throws AuthorException {
        if (authorId < 1) {
            throw new AuthorException(AUTHOR_ID_ERROR_MSG);
        }

        this.authorId = authorId;
    }

    /**
     *
     * @return
     */
    @Override
    public Book getAuthorBook() {

        Book book = bookDao.searchBook(isbn);
        return book;
    }
}
