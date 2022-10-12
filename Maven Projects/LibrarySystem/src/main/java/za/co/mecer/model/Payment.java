package za.co.mecer.model;

import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.Payments;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Payment implements Payments {

    private double amount;
    private int paymentId;

    public Payment(double amount) throws PaymentException {
        setAmount(amount);
    }

    public Payment(int paymentId, double amount) throws PaymentException {
        setAmount(amount);
        this.paymentId = paymentId;
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

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return String.format("Payment Id: %d%n"
                + "Paid Amount:  %.2f%n%n", paymentId, amount);
    }

}
