package za.co.mecer.player;

import za.co.mecer.interfaces.CardsInterface;
import za.co.mecer.interfaces.PlayerInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Player implements CardsInterface, PlayerInterface {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name.toUpperCase();
    }

}
