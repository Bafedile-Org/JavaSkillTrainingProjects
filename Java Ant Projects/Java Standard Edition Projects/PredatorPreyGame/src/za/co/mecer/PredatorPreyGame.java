package za.co.mecer;

import za.co.mecer.game.Game;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PredatorPreyGame {

    public static void main(String[] args) {
        new PredatorPreyGame().run();
    }

    private void run() {
        Game game = new Game();
        game.play();
    }

}
