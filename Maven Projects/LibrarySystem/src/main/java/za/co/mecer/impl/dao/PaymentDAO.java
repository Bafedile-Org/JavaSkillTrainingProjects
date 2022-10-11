package za.co.mecer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.payment.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface PaymentDAO {

    public void addPayment(int loanId, Payment payment) throws SQLException;

    public void removePayment(int loanId) throws SQLException;

    public ResultSet getAllPayments() throws SQLException;

    public ResultSet getPayment(int loanId) throws SQLException;

}
