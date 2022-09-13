
package za.co.mecer.bank.bankaccount.chequeaccount;

import za.co.mecer.bank.bankaccount.BankAccount;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class ChequeAccount extends BankAccount{
    @Override
    public double determineChargeFee(double amount) {
        if (amount >= 0) {
            if (amount >= 1000) {
                chargeFee = (amount/1000)*8.00;
                if(amount >=10000){
                    chargeFee = (amount/1000)*18.00;
                }
            } else {
                chargeFee = 6.50;
            }
        }
        return chargeFee;
    }
}
