package za.co.mecer;

import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Payments {

    public String AMOUNT_ERROR_MSG = "A Payable Amount Should Be 0 or More!!";

    public void setAmount(double amount) throws PaymentException;

    public double getAmount();

}
