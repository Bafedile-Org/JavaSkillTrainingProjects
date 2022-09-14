package za.co.mecer.bank.bankaccount.creditaccount;

import za.co.mecer.bank.bankaccount.BankAccount;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class CreditCardAccount extends BankAccount {

    /**
     * Credit Amount means the maximum amount available to be drawn under the
     * Credit credit balance is the sum of borrowed funds
     *
     * @param amount
     * @return
     */
    private double creditLimit;

    public CreditCardAccount() {
        this.creditLimit = creditLimit = 1500.0;
    }

    public CreditCardAccount(double creditLimit, double amount) {
        super(amount);
        this.creditLimit = creditLimit;
    }

    @Override
    public double determineChargeFee(double amount) {
        if (amount >= 0.0) {
            if (amount >= 1000) {
                chargeFee = (amount / 1000) * 13.00;
            } else {
                chargeFee = (amount / 100) * 9.50;
            }
        }
        return chargeFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > (this.getBalance() + creditLimit)) {
            System.err.printf("Insufficient Funds%n");
        } else {
            this.amount = this.getBalance() - amount;
            if (this.amount < 0) {
                this.amount += creditLimit;
                creditLimit -= this.amount;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Your Credit Card Account has%n"
                + "Credit Balance: %.2f%n"
                + "Credit Amount: %.2f%n", getBalance(), creditLimit);
    }

}
