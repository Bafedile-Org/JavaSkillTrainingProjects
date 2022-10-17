package za.co.mecer.model.dao.test;

import java.sql.Connection;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import za.co.mecer.dao.ClientDAO;
import za.co.mecer.dao.LoanDAO;
import za.co.mecer.dao.PaymentDAO;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.dao.impl.LoanDAOImpl;
import za.co.mecer.dao.impl.PaymentDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.model.Client;
import za.co.mecer.model.Loan;
import za.co.mecer.model.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentDAOTest {

    static Connection conn;
    static LoanDAO loanDao;
    static ClientDAO clientDao;
    static int loanId;
    static String clientIdentity;
    static PaymentDAO paymentDao;

    public PaymentDAOTest() {
    }

    @BeforeAll
    public static void setUp() {
        conn = DatabaseConnection.getInstance().getConnection();

        try {
            clientIdentity = "1234567890124";
            clientDao = new ClientDAOImpl(conn);
            clientDao.addClient(new Client("Dan", "Brown", clientIdentity, "England, London", "0123456789", "", ""));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex));
        }
        try {
            loanDao = new LoanDAOImpl(conn);
            loanDao.addLoan(clientIdentity, new Loan(LocalDate.now(), LocalDate.now().plusWeeks(2), 12));
            loanId = loanDao.getLoanId(clientIdentity);
        } catch (LoanException ex) {
            System.out.println(String.format("Error: %s%n", ex));
        }
        try {
            paymentDao = new PaymentDAOImpl(conn);
            paymentDao.addPayment(loanId, new Payment(20));

        } catch (PaymentException ex) {
            System.out.println(String.format("Error: %s%n", ex));
        }

    }

    @AfterAll
    public static void closeUp() {
        paymentDao.removePayment(loanId);
        loanDao.removeLoan(loanId);
        clientDao.removeClient(clientIdentity);

    }

    @Test
    public void assertGetPaymentNotNull() {
        assertNotNull(paymentDao.getPayment(loanId));
    }

    @Test
    public void assertGetPaymentNull() {
        assertNull(paymentDao.getPayment(0));
    }

}
