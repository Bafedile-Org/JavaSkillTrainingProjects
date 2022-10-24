package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Book;
import za.co.mecer.services.BookService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookServiceImpl implements BookService {

    BookDAOImpl bookImpl;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public BookServiceImpl(Connection conn) throws SQLException {
        this.bookImpl = new BookDAOImpl(conn);
    }

    /**
     *
     * @param choice
     * @throws SQLException
     * @throws IOException
     * @throws BookException
     */
    @Override
    public void processBookMenu(int choice) throws SQLException, IOException, BookException {
        switch (choice) {
            case 1:
                bookImpl.addBook(getBookDetails());
                break;
            case 2:
                bookImpl.searchBook(getBookSearchDetails());
                bookImpl.displayBooks();
                break;
            case 3:
                System.out.println("Available Books\n--------------------------------\n");
                bookImpl.searchAvailableBooks();
                bookImpl.displayBooks();
                break;
            case 4:
                System.out.println("Accessible Books\n--------------------------------\n");
                bookImpl.searchAccessibleBooks();
                bookImpl.displayBooks();
                break;
            case 5:
                bookImpl.changeBookAvailability(getBookSearchDetails(), updateBook("availability"));
                break;
            case 6:
                bookImpl.changeBookAvailability(getBookSearchDetails(), updateBook("accessibility"));
                break;
            case 7:
                bookImpl.getAllBooks();
                bookImpl.displayBooks();
                break;
            default:
                System.out.println("EXITED BOOK MENU!!");
        }
    }

    /**
     *
     * @param str
     * @return
     */
    @Override
    public boolean updateBook(String str) {
        System.out.println(String.format("Update Book %s(true/false): ", str));
        return input.nextBoolean();

    }

    /**
     *
     * @param set
     * @throws SQLException
     */
    @Override
    public void displayBooks(ResultSet set) throws SQLException {

        while (set.next()) {
            System.out.println(String.format("Book title: %S%n"
                    + "Book ISBN Number: %s%n"
                    + "Book Availability: %s%n"
                    + "Book Accessibility: %s%n",
                    set.getString("title"),
                    set.getString("isbn"),
                    set.getBoolean("available"),
                    set.getBoolean("borrowable")));
        }
    }

    /**
     *
     * @return @throws IOException
     * @throws za.co.mecer.exceptions.BookException
     */
    @Override
    public Book getBookDetails() throws IOException, BookException {
        System.out.println("Please enter the book title: ");
        String title = reader.readLine();

        System.out.println("Please enter the book ISBN Number: ");
        String isbn = input.next();
        System.out.println("Please enter book accessibility(ture/false): ");
        boolean access = input.nextBoolean();
        System.out.println("Please enter book availability(ture/false): ");
        boolean available = input.nextBoolean();
        return new Book(title, isbn, available, access);

    }

    @Override
    public String getBookSearchDetails() {
        System.out.println("Please enter book isbn number:");
        String isbn = input.next();
        return isbn;

    }
}
