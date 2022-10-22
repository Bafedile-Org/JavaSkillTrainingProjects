package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.Book;
import za.co.mecer.services.BookService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookServiceImpl implements BookService {

    BookDAOImpl bookImpl;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BookServiceImpl() throws SQLException {
        this.bookImpl = new BookDAOImpl();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookImpl.getAllBooks();
    }
}
