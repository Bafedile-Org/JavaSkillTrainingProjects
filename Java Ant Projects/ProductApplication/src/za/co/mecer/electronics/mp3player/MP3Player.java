package za.co.mecer.electronics.mp3player;

import za.co.mecer.electronics.Electronics;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MP3Player extends Electronics {

    private String colour;

    public MP3Player(double regularPrice, String manufacturer, String colour) {
        super(regularPrice, manufacturer);
        this.colour = colour;
    }

}
