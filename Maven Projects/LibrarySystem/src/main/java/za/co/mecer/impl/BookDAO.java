package za.co.mecer.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.book.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookDAO {

    public void addBook(Book book) throws SQLException;

    public void removeBook(String isbn) throws SQLException;

    public void changeBookAvailability(String isbn, boolean availability) throws SQLException;

    public void changeBookAccessiblity(String isbn, boolean access) throws SQLException;

    public ResultSet searchBook(String ISBN, String title) throws SQLException;

}
