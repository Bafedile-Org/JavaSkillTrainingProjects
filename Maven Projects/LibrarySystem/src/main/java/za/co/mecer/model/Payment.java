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

    /**
     *
     * @param amount
     * @throws PaymentException
     */
    public Payment(double amount) throws PaymentException {
        setAmount(amount);
    }

    /**
     *
     * @param paymentId
     * @param amount
     * @throws PaymentException
     */
    public Payment(int paymentId, double amount) throws PaymentException {
        setAmount(amount);
        this.paymentId = paymentId;
    }

    /**
     *
     * @param amount
     * @throws PaymentException
     */
    @Override
    public void setAmount(double amount) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException(AMOUNT_ERROR_MSG);
        }
        this.amount = amount;
    }

    /**
     * Returns an amount
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Payment Id: %d%n"
                + "Paid Amount:  %.2f%n%n", paymentId, amount);
    }

}
