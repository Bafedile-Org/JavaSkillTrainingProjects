package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static za.co.mecer.Books.BOOK_NOT_FOUND_MSG;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookDAOImpl implements BookDAO {

    private PreparedStatement preparedStatement = null;
    private Connection conn = null;
    private ResultSet result = null;
    private List<Book> books = new ArrayList<>();

    public BookDAOImpl(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @Override
    public void addBook(Book book) {
        /**
         * <<Book fields>> isbn, title,available, borrowable
         */
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO book (isbn,title,available,borrowable) VALUES"
                        + "(?,?,?,?)");
                preparedStatement.setString(1, book.getISBN());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setBoolean(3, true);
                preparedStatement.setBoolean(4, true);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void removeBook(String isbn) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE FROM book WHERE isbn=?");
                preparedStatement.setString(1, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void changeBookAvailability(String isbn, boolean availability) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE book SET available=? WHERE isbn =?");
                preparedStatement.setBoolean(1, availability);
                preparedStatement.setString(2, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void changeBookAccessiblity(String isbn, boolean access) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE book SET borrowable=? WHERE isbn =?");
                preparedStatement.setBoolean(1, access);
                preparedStatement.setString(2, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public Book searchBook(String ISBN) {
        Book book = null;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE isbn=? ");
                preparedStatement.setString(1, ISBN);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return book;
    }

    @Override
    public void searchAvailableBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE available=?");
                preparedStatement.setBoolean(1, true);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void searchAccessibleBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE borrowable=?");
                preparedStatement.setBoolean(1, true);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

    }

    @Override
    public void getAllBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book ");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    @Override
    public void close(PreparedStatement preparedStatement, ResultSet result) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ex) {
                System.err.println("Error " + ex.getMessage());
            }
        }
    }

    @Override
    public void displayBooks() throws BookException {
        if (books.isEmpty()) {
            throw new BookException(BOOK_NOT_FOUND_MSG);
        }
        books.forEach((book) -> System.out.println(book));
    }

    @Override

    public int getBookId(String isbn) {
        int bookId;
        Book book = searchBook(isbn);
        bookId = book.getBookId();
        System.out.println("Book id: " + bookId);
        return bookId;
    }

}
