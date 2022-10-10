package za.co.mecer;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ShoulderSurfing {

    private int[] randomNumber = new int[10];
    private int[] encryptedPassword = new int[5];

    public void run() {
        String secretNum = "12345";

        randomNumberGenerator();
        printRandomNumbers();
        System.out.print("Please enter your pin: ");
        Scanner input = new Scanner(System.in);
        String password = input.next();
        encryptPassword(secretNum);
        if (verification(password)) {
            System.out.println("You have Access");
        } else {
            System.out.println("Access Denied!");
        }

    }

    public void randomNumberGenerator() {
        for (int i = 0; i < randomNumber.length; i++) {
            randomNumber[i] = (int) (Math.random() * 3) + 1;
        }
    }

    public void encryptPassword(String pass) {
        String[] splitPass = pass.split("");
        for (int i = 0; i < splitPass.length; i++) {
            encryptedPassword[i] = randomNumber[Integer.parseInt(splitPass[i])];
        }

    }

    public boolean verification(String inputPassword) {
        String[] userPassword = inputPassword.split("");
        for (int i = 0; i < userPassword.length; i++) {
            if (Integer.parseInt(userPassword[i]) != encryptedPassword[i]) {
                return false;
            }
        }
        return true;
    }

    public void printRandomNumbers() {
        System.out.println("PIN: 0 1 2 3 4 5 6 7 8 9");
        System.out.print("NUM: ");
        for (int i = 0; i < randomNumber.length; i++) {
            System.out.printf("%d ", randomNumber[i]);
        }
        System.out.println("");
    }
}
