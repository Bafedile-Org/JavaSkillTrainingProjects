
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class PigGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1 = new Player("Dimakatso");
        int rollCounter = 3;

        System.out.printf("Player Name [%s]%n", p1.getName());
        while (rollCounter > 0 && rollCounter <= 3) {
            p1.rollDice();
            rollCounter--;
        }

        System.out.println(p1.toString());
    }

}
