package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ArmstrongNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ArmstrongNumbers().run();

    }

    private void run() {
        for (int i = 0; i < 1000; i++) {
            determineArmstrongNumber(i);
        }
    }

    private void determineArmstrongNumber(int num) {
        int total = 0;
        String numString = String.valueOf(num);

        if (num > 10) {
            for (int i = 0; i < numString.length(); i++) {
                total += Math.pow(Integer.parseInt(String.valueOf(numString.charAt(i))), numString.length());
            }

            if (total == num) {
                System.out.printf("%d is an Armstrong%n", num);
            }
        }
    }

}
