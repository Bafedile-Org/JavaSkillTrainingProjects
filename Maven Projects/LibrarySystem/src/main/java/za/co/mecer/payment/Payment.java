package za.co.mecer.payment;

import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.impl.Payments;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Payment implements Payments {

    private double amount;

    public Payment(double amount) throws PaymentException {
        setAmount(amount);
    }

    @Override
    public void setAmount(double amount) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException(AMOUNT_ERROR_MSG);
        }
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

}
