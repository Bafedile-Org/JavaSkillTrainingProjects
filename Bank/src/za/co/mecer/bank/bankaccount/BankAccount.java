package za.co.mecer.bank.bankaccount;

import za.co.mecer.interfaces.Account;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public abstract class BankAccount implements Account {

    protected double amount, chargeFee;

    public BankAccount() {
        this.deposit(0.0);
    }

    public BankAccount(double amount) {
        this.amount = amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            this.amount += amount;
        }
    }

    @Override
    public double getBalance() {
        return amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > this.getBalance()) {
            System.err.printf("Insufficient Funds%n"
                    + "You have %.2f in your account%n%n", this.getBalance());
        } else {
            this.amount = this.getBalance() - (amount + determineChargeFee(amount));
            System.out.printf("%n%.2f Withdrawn%n%n", amount);
        }

    }

}
