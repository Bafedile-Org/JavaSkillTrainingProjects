package za.co.mecer;

import za.co.mecer.game.Game;

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
            Game game = new Game();
            game.populateCardsArray();

        } catch (IllegalArgumentException ex) {
            System.out.printf("%s%n", ex.getMessage());
        }
    }

}
