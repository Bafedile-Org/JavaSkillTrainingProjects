package za.co.mecer;

import za.co.mecer.soduku.Soduku;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SodukuSimulation {

    public static void main(String[] args) {
        new SodukuSimulation().run();
    }

    private void run() {
        Soduku soduku = new Soduku();
        soduku.populateGrid();
//        soduku.displayGrid();
    }

}
