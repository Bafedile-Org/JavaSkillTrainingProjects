package za.co.mecer.interfaces;

import za.co.mecer.exception.InsufficientFundsException;
import za.co.mecer.exception.InvalidDepositException;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public interface Account {

    void deposit(double amount) throws InvalidDepositException;

    double getBalance();

    void withdraw(double amount) throws InsufficientFundsException;

    double determineChargeFee(double amount);
}
