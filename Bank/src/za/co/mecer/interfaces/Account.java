
package za.co.mecer.interfaces;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public interface Account {
    void deposit(double amount);
    default double getBalance(){
        return 0.0;
    }
    void withdraw(double amount);
    double determineChargeFee(double amount);
}
