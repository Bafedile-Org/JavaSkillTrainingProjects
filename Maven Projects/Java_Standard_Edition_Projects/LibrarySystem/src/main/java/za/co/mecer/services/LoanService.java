package za.co.mecer.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.model.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoanService {

    public void processLoanMenu(int choice) throws SQLException, LoanException, ClientException, IOException;

    public double getLoanFine();

    public void displayLoan(ResultSet set) throws SQLException;

    public int getLoanId();

    public LocalDate getReturnDate();

    public Loan getLoanDetails() throws LoanException;
}
