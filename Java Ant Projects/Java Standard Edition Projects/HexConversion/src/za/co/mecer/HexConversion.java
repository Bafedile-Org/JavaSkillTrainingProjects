package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class HexConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HexConversion().run(args);
    }

    private void run(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                System.out.printf("Dec: %d%n"
                        + "Hex: %s%n%n", Integer.parseInt(args[i]), Integer.toHexString(Integer.parseInt(args[i])).toUpperCase());
            }
        } catch (NumberFormatException ex) {
            System.out.printf("Error: %s%n%n", ex.getMessage());
        }
    }
}
