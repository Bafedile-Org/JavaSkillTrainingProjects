package za.co.mecer.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookService {

    public void processBookMenu(int choice) throws SQLException, IOException, BookException;

    public boolean updateBook(String str);

    public void displayBooks(ResultSet set) throws SQLException;

    public String getBookSearchDetails();

    public Book getBookDetails() throws IOException, BookException;
}
