
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
import java.util.Scanner;

public class FizzyDrinks {

    private final int RATIO = 1000;
    private final double sweetner = 0.01;

    public static void main(String[] args) {
        new FizzyDrinks().run();

    }

    private void run() {
        double mouseLethalDosage, mouseWeight, humanWeight;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the mouse weight in (grams): ");
        mouseWeight = input.nextDouble();

        System.out.print("Enter the amount of sweetner \nthat can kill a mouse "
                + "in (grams): ");
        mouseLethalDosage = input.nextDouble();

        System.out.print("Enter your weight in (kilograms): ");
        humanWeight = input.nextDouble() * RATIO;

        System.out.println("=================================================");
        System.out.println("\t\t\tRESULTS");
        System.out.println("=================================================");

        System.out.printf("Do not exceed %d number of fizzy drinks%n", maxDrinksAllowed(getLethalHumanDosage(humanWeight, mouseWeight, mouseLethalDosage), sweetner));
        System.out.println("=================================================");
    }

    private double getLethalHumanDosage(double humanWeight, double mouseWeight, double mouseLethalDosage) {
        return (humanWeight * mouseLethalDosage) / mouseWeight;
    }

    private int maxDrinksAllowed(double humanLethalAmount, double sweetner) {
        return (int) Math.ceil(humanLethalAmount / sweetner) - 1;
    }

}
