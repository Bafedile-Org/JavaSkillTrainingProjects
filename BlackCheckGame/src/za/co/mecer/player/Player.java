package za.co.mecer.player;

import za.co.mecer.interfaces.CardsInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Player implements CardsInterface {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }

}
