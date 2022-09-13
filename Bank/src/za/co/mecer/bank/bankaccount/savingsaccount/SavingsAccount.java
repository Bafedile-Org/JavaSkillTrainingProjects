package za.co.mecer.bank.bankaccount.savingsaccount;

import za.co.mecer.bank.bankaccount.BankAccount;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class SavingsAccount extends BankAccount {

    @Override
    public double determineChargeFee(double amount) {
        if (amount >= 0) {
            if (amount >= 10000) {
                chargeFee = (amount/1000)*13.00;
            } else {
                chargeFee =(amount/100)* 7.50;
            }
        }
        return chargeFee;
    }
}
