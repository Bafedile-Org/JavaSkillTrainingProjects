package za.co.mecer.bank;

import java.util.Scanner;
import za.co.mecer.bank.bankaccount.chequeaccount.ChequeAccount;
import za.co.mecer.bank.bankaccount.creditaccount.CreditCardAccount;
import za.co.mecer.bank.bankaccount.savingsaccount.SavingsAccount;
import za.co.mecer.interfaces.Account;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Bank().run();

    }

    private void run() {
        Account credit = new CreditCardAccount();
        Account sav = new SavingsAccount(1200);
        Account cheq = new ChequeAccount(3000);

        int choice;

        do {
            choice = getChoice();

            if (choice > 0 && choice < 4) {
                int accType = getAccountType();

                makeTransations(accType, choice, sav, cheq, credit);
            }

        } while (choice != 4);

    }

    private int getChoice() {
        int choice;
        do {
            System.out.print("Please choose from the below\n"
                    + "1 Deposit Money\n"
                    + "2 Get Available Balance\n"
                    + "3 Make A Withdrawal\n"
                    + "4 Exit The Program\n"
                    + "Your choice: ");
            choice = input.nextInt();

            if (choice == 4) {
                break;
            }
        } while (choice < 1 && choice > 4);

        return choice;
    }

    private double getAmount() {
        double amount;
        do {
            System.out.print("Please enter an amount: ");
            amount = input.nextDouble();

        } while (amount < 0.0);

        return amount;
    }

    private int getAccountType() {
        int choice;
        do {
            System.out.print("Please choose account type below\n"
                    + "1 Savings Account\n"
                    + "2 Cheque Account\n"
                    + "3 Credit Account\n"
                    + "Your choice: ");
            choice = input.nextInt();
        } while (choice > 3 && choice < 1);

        return choice;
    }

    private void makeTransations(int accountType, int choice, Account sav, Account cheq, Account credit) {
        switch (choice) {
            case 1:
                switch (accountType) {
                    case 1:
                        sav.deposit(getAmount());
                        break;
                    case 2:
                        cheq.deposit(getAmount());
                        break;
                    default:
                        credit.deposit(getAmount());
                }
                break;
            case 2:
                switch (accountType) {
                    case 1:
                        System.out.printf("Available Balance: %.2f%n%n", sav.getBalance());
                        break;
                    case 2:
                        System.out.printf("Available Balance: %.2f%n%n", cheq.getBalance());
                        break;
                    default:
                        System.out.println(credit);
                }
                break;
            default:
                switch (accountType) {
                    case 1:
                        sav.withdraw(getAmount());
                        break;
                    case 2:
                        cheq.withdraw(getAmount());
                        break;
                    default:
                        credit.withdraw(getAmount());
                }
                break;
        }
    }

}
