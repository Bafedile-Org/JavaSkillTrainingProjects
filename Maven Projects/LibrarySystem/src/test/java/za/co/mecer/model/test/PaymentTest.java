package za.co.mecer.model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.model.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentTest {

    static Payment payment;

    public PaymentTest() {
    }

    @BeforeAll
    public static void setUp() {
        try {
            payment = new Payment(1, 23);
        } catch (PaymentException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertSetPaymentIdThrows() {
        assertThrows(PaymentException.class, () -> payment.setPaymentId(0));
    }

    @Test
    public void assertSetPaymentAmountThrows() {
        assertThrows(PaymentException.class, () -> payment.setAmount(-20));
    }

    @Test
    public void assertGetPaymentAmountNotNegative() {
        assertTrue(payment.getAmount() >= 0);
    }

    @Test
    public void assertGetPaymentIdNotZero() {
        assertTrue(payment.getPaymentId() > 0);
    }
}
