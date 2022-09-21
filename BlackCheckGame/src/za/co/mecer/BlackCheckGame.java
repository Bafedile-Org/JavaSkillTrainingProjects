package za.co.mecer;

import za.co.mecer.game.Game;
import za.co.mecer.interfaces.GameInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BlackCheckGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BlackCheckGame().run();
    }

    private void run() {
        try {
            GameInterface game = new Game();
            game.populateCardsArray();
            game.playGame();

        } catch (IllegalArgumentException ex) {
            System.out.printf("%s%n", ex.getMessage());
        }
    }

}
