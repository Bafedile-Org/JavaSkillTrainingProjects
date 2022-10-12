package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.model.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface PaymentDAO {

    public void addPayment(int loanId, Payment payment);

    public void removePayment(int loanId);

    public void getAllPayments();

    public Payment getPayment(int loanId);

    void displayPayments();

    public void close(PreparedStatement preparedStatement, ResultSet result);

}
