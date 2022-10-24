package za.co.mecer.electronics.television;

import za.co.mecer.electronics.Electronics;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Television extends Electronics {

    private int size;

    public Television(double regularPrice, String manufacturer, int size) {
        super(regularPrice, manufacturer);
        this.size = size;
    }

}
