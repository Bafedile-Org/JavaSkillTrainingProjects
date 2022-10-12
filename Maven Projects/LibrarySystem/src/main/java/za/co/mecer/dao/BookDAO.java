package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookDAO {

    public int getBookId(String isbn);

    public void addBook(Book book);

    public void getAllBooks();

    public void removeBook(String isbn);

    public void changeBookAvailability(String isbn, boolean availability);

    public void changeBookAccessiblity(String isbn, boolean access);

    public Book searchBook(String ISBN);

    public void searchAvailableBooks();

    public void searchAccessibleBooks();

    public void close(PreparedStatement preparedStatement, ResultSet result);

    public void displayBooks() throws BookException;

}
