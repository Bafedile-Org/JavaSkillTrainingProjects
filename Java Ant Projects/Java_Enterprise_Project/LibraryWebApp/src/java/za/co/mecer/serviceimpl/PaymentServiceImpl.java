package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.modelImpl.Payment;
import za.co.mecer.dao.impl.PaymentDAOImpl;
import za.co.mecer.services.PaymentService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentServiceImpl implements PaymentService {

    PaymentDAOImpl paymentImpl;
    LoanServiceImpl loanService;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param conn
     */
    public PaymentServiceImpl(Connection conn) {
        this.paymentImpl = new PaymentDAOImpl(conn);
        this.loanService = new LoanServiceImpl(conn);
    }

    /**
     *
     * @param choice
     * @throws SQLException
     * @throws PaymentException
     */
    @Override
    public void processPaymentMenu(int choice) throws SQLException, PaymentException {
        switch (choice) {
            case 1:
                paymentImpl.addPayment(loanService.getLoanId(), new Payment(getPayment()));
                break;
            case 2:
                paymentImpl.getPayment(loanService.getLoanId());
                paymentImpl.displayPayments();
                break;
            case 3:
                paymentImpl.removePayment(loanService.getLoanId());
                break;
            case 4:
                paymentImpl.getAllPayments();
                paymentImpl.displayPayments();
                break;
            default:
                System.out.println("EXITED PAYMENT MENU!!!");
        }

    }

    /**
     *
     * @param set
     * @throws SQLException
     */
    @Override
    public void displayPayment(ResultSet set) throws SQLException {
        while (set.next()) {
            System.out.println(String.format("Payment Id: %d%n"
                    + "Loan Id: %d%n"
                    + "Amount paid: .2f%f%n%n", set.getInt("payment_id"), set.getInt("loan_id"), set.getDouble("amount")));
        }
    }

    /**
     *
     * @return
     */
    @Override
    public double getPayment() {
        boolean isValid;
        double amount = 0;
        do {
            try {
                System.out.println("Please enter the amount to pay for the loan");
                amount = input.nextDouble();
                isValid = !(amount < 0);
            } catch (InputMismatchException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return amount;

    }
}
