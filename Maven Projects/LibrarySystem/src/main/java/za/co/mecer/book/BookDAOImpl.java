package za.co.mecer.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.impl.BookDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookDAOImpl implements BookDAO {

    private PreparedStatement preparedStatement = null;
    private Connection con = null;

    public BookDAOImpl(Connection con) throws SQLException {
        this.con = con;
    }

    @Override
    public void addBook(Book book) throws SQLException {
        /**
         * <<Book fields>> isbn, title,available, borrowable
         */
        preparedStatement = con.prepareStatement("INSERT INTO book (isbn,title,available,borrowable) VALUES"
                + "(?,?,?,?)");
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setBoolean(3, true);
        preparedStatement.setBoolean(4, true);
        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void removeBook(String isbn) throws SQLException {
        preparedStatement = con.prepareStatement("DELETE FROM book WHERE isbn=?");
        preparedStatement.setString(1, isbn);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeBookAvailability(String isbn, boolean availability) throws SQLException {
        preparedStatement = con.prepareStatement("UPDATE book SET available=? WHERE isbn =?");
        preparedStatement.setBoolean(1, availability);
        preparedStatement.setString(2, isbn);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void changeBookAccessiblity(String isbn, boolean access) throws SQLException {
        preparedStatement = con.prepareStatement("UPDATE book SET borrowable=? WHERE isbn =?");
        preparedStatement.setBoolean(1, access);
        preparedStatement.setString(2, isbn);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public ResultSet searchBook(String ISBN, String title) throws SQLException {
        preparedStatement = con.prepareStatement("SELECT * FROM book WHERE isbn=? AND title =?");
        preparedStatement.setString(1, ISBN);
        preparedStatement.setString(2, title);
        ResultSet result = preparedStatement.executeQuery();
        preparedStatement.close();
        return result;
    }

}
