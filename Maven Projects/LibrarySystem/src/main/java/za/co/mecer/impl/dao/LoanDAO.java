package za.co.mecer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import za.co.mecer.client.Client;
import za.co.mecer.loan.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoanDAO {

    public double FINE = 12.5;

    public ResultSet getAllLoans() throws SQLException;

    void addLoan(String clientIdentityNum, Loan loan) throws SQLException;

    void removeLoan(int loanId) throws SQLException;

    void changeReturnDate(int loanId, LocalDate newReturnDate) throws SQLException;

    void addFine(int loanId, Double fine) throws SQLException;

    ResultSet searchLoan(int loanId) throws SQLException;
}
