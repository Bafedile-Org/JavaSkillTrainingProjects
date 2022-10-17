package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.dao.ClientDAO;
import za.co.mecer.dao.LoanDAO;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.dao.impl.LoanDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.model.Client;
import za.co.mecer.model.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanDAOTest {

    static Connection conn;
    static LoanDAO loanDao;
    static ClientDAO clientDao;
    static int loanId;
    static String clientIdentity;

    public LoanDAOTest() {
    }

    @BeforeAll
    public static void setUp() {
        conn = DatabaseConnection.getInstance().getConnection();
        loanDao = new LoanDAOImpl(conn);
        try {
            clientIdentity = "1234567890124";
            clientDao = new ClientDAOImpl(conn);
            clientDao.addClient(new Client("Dan", "Brown", clientIdentity, "England, London", "0123456789", "", ""));

            loanDao.addLoan(clientIdentity, new Loan(LocalDate.now(), LocalDate.now().plusWeeks(2), 0.0));
            loanId = loanDao.getLoanId(clientIdentity);
        } catch (ClientException | LoanException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }

    }

    @AfterAll
    public static void closeUp() {
        loanDao.removeLoan(loanId);
        clientDao.removeClient(clientIdentity);
    }

    @Test
    public void assertSearchLoanNotNull() {
        assertNotNull(loanDao.searchLoan(loanId));
    }

    @Test
    public void assertSearchLoanNull() {
        assertNull(loanDao.searchLoan(0));
    }

    @Test
    public void assertGetLoanIdNotZero() {
        assertTrue(loanDao.getLoanId(clientIdentity) > 0);
    }

    @Test
    public void assertGetLoanIdZero() {
        assertFalse(loanDao.getLoanId("1234567890125") > 0);
    }

}
