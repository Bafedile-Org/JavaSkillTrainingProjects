package za.co.mecer.model;

import java.sql.SQLException;
import za.co.mecer.AuthorBooks;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorBook implements AuthorBooks {

    private int authorId, bookId;

    private BookDAO bookDao;

    /**
     *
     * @throws SQLException
     */
    public AuthorBook() throws SQLException {
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    /**
     *
     * @param authorId
     * @param bookId
     * @throws AuthorException
     * @throws SQLException
     */
    public AuthorBook(int authorId, int bookId) throws AuthorException, SQLException {
        this.setBookId(bookId);
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    /**
     *
     * @return
     */
    @Override
    public int getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     */
    @Override
    public void setBookId(int bookId) {
        this.bookId = bookId;
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
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

}
