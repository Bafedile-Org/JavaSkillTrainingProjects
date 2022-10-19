package za.co.mecer.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface PaymentService {

    public void processPaymentMenu(int choice) throws SQLException, PaymentException;

    public void displayPayment(ResultSet set) throws SQLException;

    public double getPayment();
}
