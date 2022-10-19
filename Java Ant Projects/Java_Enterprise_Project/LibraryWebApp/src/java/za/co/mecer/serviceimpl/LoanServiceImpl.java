package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.modelImpl.Loan;
import za.co.mecer.dao.impl.LoanDAOImpl;
import za.co.mecer.services.LoanService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanServiceImpl implements LoanService {

    LoanDAOImpl loanImpl;
    ClientServiceImpl clientService;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param conn
     */
    public LoanServiceImpl(Connection conn) {
        this.loanImpl = new LoanDAOImpl(conn);
        this.clientService = new ClientServiceImpl(conn);

    }

    /**
     *
     * @param choice
     * @throws SQLException
     * @throws LoanException
     * @throws ClientException
     * @throws IOException
     */
    @Override
    public void processLoanMenu(int choice) throws SQLException, LoanException, ClientException, IOException {
        switch (choice) {
            case 1:
                loanImpl.addLoan(clientService.getClientIdentity(), getLoanDetails());
                break;
            case 2:
                loanImpl.searchLoan(getLoanId());
                loanImpl.displayLoans();
                break;
            case 3:
                loanImpl.removeLoan(getLoanId());
                break;
            case 4:
                loanImpl.changeReturnDate(getLoanId(), getReturnDate());
                break;
            case 5:
                loanImpl.getAllLoans();
                loanImpl.displayLoans();
                break;
            case 6:
                loanImpl.addFine(getLoanId(), getLoanFine());
                break;
            default:
                System.out.println("EXITED LOAN MENU!!!");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public double getLoanFine() {
        boolean isValid;
        double loanFine = 0;
        do {
            try {
                System.out.println("Please enter the loan fine: ");
                loanFine = input.nextDouble();

                isValid = !(loanFine < 0);
            } catch (InputMismatchException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);
        return loanFine;
    }

    /**
     *
     * @param set
     * @throws SQLException
     */
    @Override
    public void displayLoan(ResultSet set) throws SQLException {
        while (set.next()) {
            System.out.println(String.format("Book borrowed date: %s%n"
                    + "Book return date: %s%n"
                    + "Book fine:  %.2f%n", set.getDate("borrowedDate"),
                    set.getDate("returnDate"), set.getDouble("fine")));
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getLoanId() {
        int loanId = 0;
        boolean isValid;
        do {
            try {
                System.out.println("Please enter loan id: ");
                loanId = input.nextInt();
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);
        return loanId;
    }

    /**
     *
     * @return
     */
    @Override
    public LocalDate getReturnDate() {
        System.out.println("Please enter return  date (dd-MM-YYYY): ");
        String returnDateString = input.next();
        LocalDate returnDate = LocalDate.of(Integer.parseInt(returnDateString.split("-")[2]),
                Integer.parseInt(returnDateString.split("-")[1]), Integer.parseInt(returnDateString.split("-")[0]));
        System.out.println(returnDate.toString());
        return returnDate;
    }

    /**
     *
     * @return @throws LoanException
     */
    @Override
    public Loan getLoanDetails() throws LoanException {
        System.out.println("Please enter borrowed date (dd-MM-YYYY): ");
        String dateString = input.next();
        LocalDate borrowedDate = LocalDate.of(Integer.parseInt(dateString.split("-")[2]),
                Integer.parseInt(dateString.split("-")[1]), Integer.parseInt(dateString.split("-")[0]));
        LocalDate returnDate = getReturnDate();
        return new Loan(borrowedDate, returnDate, 0);
    }
}
