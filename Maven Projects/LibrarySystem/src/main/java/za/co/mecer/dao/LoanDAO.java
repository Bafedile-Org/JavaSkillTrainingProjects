package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import za.co.mecer.model.Client;
import za.co.mecer.model.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoanDAO {

    public double FINE = 12.5;

    public void getAllLoans();

    void addLoan(String clientIdentityNum, Loan loan);

    void removeLoan(int loanId);

    void changeReturnDate(int loanId, LocalDate newReturnDate);

    void addFine(int loanId, double fine);

    Loan searchLoan(int loanId);

    public void close(PreparedStatement preparedStatement, ResultSet result);

    public void displayLoans();
}
