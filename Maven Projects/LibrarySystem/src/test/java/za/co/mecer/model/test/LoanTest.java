package za.co.mecer.model.test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.model.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanTest {

    static Loan loan;

    public LoanTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            loan = new Loan(1, LocalDate.now(), LocalDate.now().plusWeeks(2), 0);
        } catch (LoanException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertSetLoanIdThrows() {
        assertThrows(LoanException.class, () -> loan.setLoanId(0));
    }

    @Test
    public void assertSetFineThrows() {
        assertThrows(LoanException.class, () -> loan.setFine(-20));
    }

    @Test
    public void assertSetDate() {
        assertTrue(loan.getBorrowedDate() instanceof LocalDate);
        assertTrue(loan.getReturnDate() instanceof LocalDate);
    }

    @Test
    public void assertGetFineNotNegative() {
        assertTrue(loan.getFine() >= 0);
    }
}
