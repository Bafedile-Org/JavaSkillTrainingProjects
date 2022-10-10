package za.co.mecer.loan;

import java.time.LocalDate;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.impl.Loans;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Loan implements Loans {

    private LocalDate borrowedDate, returnDate;
    private double fine;

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

}
