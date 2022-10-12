package za.co.mecer.model;

import java.time.LocalDate;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.Loans;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Loan implements Loans {

    private LocalDate borrowedDate, returnDate;
    private double fine;
    private int loanId;

    public Loan(int loanId, LocalDate borrowedDate, LocalDate returnDate, double Fine) throws LoanException {
        this.loanId = loanId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.setFine(Fine);
    }

    public Loan(LocalDate borrowedDate, LocalDate returnDate, double Fine) throws LoanException {
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.setFine(Fine);
    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    @Override
    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public void setFine(double fine) throws LoanException {
        if (fine < 0) {
            throw new LoanException(FINE_ERROR_MSG);
        }
        this.fine = fine;
    }

    @Override
    public double getFine() {
        return fine;
    }

    @Override
    public String toString() {
        return String.format("Book borrowed date: %s%n"
                + "Book return date: %s%n"
                + "Book fine:  %.2f%n", borrowedDate, returnDate, fine);
    }

    /**
     * @return the loanId
     */
    public int getLoanId() {
        return loanId;
    }

    /**
     * @param loanId the loanId to set
     */
    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

}
