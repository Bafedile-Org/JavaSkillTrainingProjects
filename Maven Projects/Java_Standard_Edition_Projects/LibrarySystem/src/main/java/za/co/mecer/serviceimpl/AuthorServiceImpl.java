package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.AuthorBookDAOImpl;
import za.co.mecer.model.Author;
import za.co.mecer.dao.impl.AuthorDAOImpl;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.services.AuthorService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorServiceImpl implements AuthorService {

    AuthorDAOImpl authorImpl;
    AuthorBookDAOImpl authorBookImpl;
    Scanner input = new Scanner(System.in);
    BookDAO bookImpl;
    String bookISBN;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Connection conn;

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public AuthorServiceImpl(Connection conn) throws SQLException {
        this.conn = conn;
        this.authorImpl = new AuthorDAOImpl(conn);
        this.authorBookImpl = new AuthorBookDAOImpl(conn);
        this.bookImpl = new BookDAOImpl(conn);
    }

    /**
     *
     * @param choice
     * @throws SQLException
     * @throws AuthorException
     * @throws IOException
     */
    @Override
    public void processAuthorMenu(int choice) throws SQLException, AuthorException, IOException {
        switch (choice) {
            case 1:
                Author author = getAuthorDetails();
                conn.setAutoCommit(false);
                authorImpl.addAuthor(author);
                authorBookImpl.addAuthorBook(authorImpl.searchAuthor(author.getName()).getAuthorId(),
                        new BookDAOImpl(conn).getBookId(bookISBN));
                conn.setAutoCommit(true);
                System.out.println(String.format("%nAUTHOR %S Added ", author.getName()));
                break;
            case 2:
                authorImpl.searchAuthor(getAuthorName());
                authorImpl.displayAuthors();
                break;
            case 3:
                author = getAuthorDetails();
                conn.setAutoCommit(false);
                authorBookImpl.removeAuthorBook(authorImpl.getAuthorId(author.getName()),
                        new BookDAOImpl(conn).getBookId(bookISBN));

                conn.setAutoCommit(true);
                System.out.println(String.format("%nAUTHOR %S Removed%n%n", author.getName()));
                break;
            case 4:
                authorImpl.getAllAuthors();
                authorImpl.displayAuthors();
                break;
            case 5:
                authorBookImpl.displayAuthorAndBook(getAuthorName());
                break;
            default:
                System.out.println("EXITED AUTHOR MENU!!");
        }
    }

    /**
     *
     * @return @throws IOException
     */
    @Override
    public String getAuthorName() throws IOException {
        System.out.println("Please enter author name: ");
        String name = reader.readLine();
        return name;
    }

    /**
     *
     * @return
     */
    public int getAuthorId() {
        boolean isValid;
        int authorId = 0;
        do {
            try {
                System.out.println("Please enter author id: ");
                authorId = input.nextInt();

                isValid = !(authorId < 0);

            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return authorId;
    }

    /**
     *
     * @return
     */
    public String getAuthorBookISBN() {
        System.out.println("Please enter author's book isbn: ");
        bookISBN = input.next();
        return bookISBN;
    }

    /**
     *
     * @return @throws AuthorException
     * @throws SQLException
     * @throws IOException
     */
    public Author getAuthorDetails() throws AuthorException, SQLException, IOException {
        String name = getAuthorName();
        bookISBN = getAuthorBookISBN();
        return new Author(name);
    }

}
