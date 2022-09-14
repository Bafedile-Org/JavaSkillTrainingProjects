package za.co.mecer.interfaces;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public interface Account {

    void deposit(double amount);

    double getBalance();

    void withdraw(double amount);

    double determineChargeFee(double amount);
}
