package za.co.mecer.bank.bankaccount;

import za.co.mecer.exception.InsufficientFundsException;
import za.co.mecer.exception.InvalidDepositException;
import za.co.mecer.interfaces.Account;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public abstract class BankAccount implements Account {

    protected double amount, chargeFee;

    public BankAccount() {
        try {
            this.deposit(0.0);
        } catch (InvalidDepositException ide) {
            System.out.printf("ERROR: %s%n", ide.getMessage());
        }
    }

    public BankAccount(double amount) {
        this.amount = amount;
    }

    @Override
    public void deposit(double amount) throws InvalidDepositException {
        if (amount >= 0) {
            this.amount += amount;
        } else {
            throw new InvalidDepositException("You can not deposit amount less than 0");
        }
    }

    @Override
    public double getBalance() {
        return amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.getBalance()) {
            throw new InsufficientFundsException(String.format("Insufficient Funds%n"
                    + "You have %.2f in your account%n%n", this.getBalance()));
        } else {
            this.amount = this.getBalance() - (amount + determineChargeFee(amount));
            System.out.printf("%n%.2f Withdrawn%n%n", amount);
        }

    }

}
