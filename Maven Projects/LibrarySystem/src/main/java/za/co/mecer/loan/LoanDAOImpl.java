package za.co.mecer.loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import za.co.mecer.client.Client;
import za.co.mecer.impl.dao.LoanDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanDAOImpl implements LoanDAO {

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public LoanDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addLoan(String clientIdentityNum, Loan loan) throws SQLException {
        /**
         * <<Loan Fields>> client_id, borroweddate, returndate, fine
         */
        preparedStatement = conn.prepareStatement("INSERT INTO loan (client_id,borroweddate, returndate,fine)"
                + "VALUES ((SELECT client_id FROM client WHERE identityNum = ?),?,?,?)");

        preparedStatement.setString(1, clientIdentityNum);
        preparedStatement.setString(2, loan.getBorrowedDate().toString());
        preparedStatement.setString(3, loan.getReturnDate().toString());
        preparedStatement.setDouble(4, loan.getFine());
        preparedStatement.executeUpdate();
    }

    @Override
    public void removeLoan(int loanId) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM loan WHERE loan_id = ? ");
        preparedStatement.setInt(1, loanId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void changeReturnDate(int loanId, LocalDate newReturnDate) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE loan SET returndate = ? WHERE loan_id = ?");
        preparedStatement.setString(1, newReturnDate.toString());
        preparedStatement.setInt(2, loanId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void addFine(int loanId, Double fine) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE loan SET fine = ? WHERE loan_id = ?");
        preparedStatement.setDouble(1, FINE);
        preparedStatement.setInt(2, loanId);
        preparedStatement.executeUpdate();

    }

    @Override
    public ResultSet searchLoan(int loanId) throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM loan WHERE loan_id =?");
        preparedStatement.setInt(1, loanId);
        result = preparedStatement.executeQuery();

        return result;

    }

    @Override
    public ResultSet getAllLoans() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM loan");
        result = preparedStatement.executeQuery();

        return result;

    }

}
