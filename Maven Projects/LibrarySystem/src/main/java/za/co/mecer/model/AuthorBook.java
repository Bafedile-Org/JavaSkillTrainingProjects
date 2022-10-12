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

    public AuthorBook() throws SQLException {
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    public AuthorBook(int authorId, int bookId) throws AuthorException, SQLException {
        this.setBookId(bookId);
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl(DatabaseConnection.getInstance().getConnection());
    }

    @Override
    public int getBookId() {
        return bookId;
    }

    @Override
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public int getAuthorId() {
        return authorId;
    }

    @Override
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

}
