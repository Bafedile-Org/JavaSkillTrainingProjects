package za.co.mecer.electronics;

import za.co.mecer.interfaces.electronics.ElectronicsInterface;
import za.co.mecer.product.Product;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Electronics extends Product implements ElectronicsInterface {

    private String manufacturer;

    public Electronics(double regularPrice, String manufacturer) {
        super(regularPrice);
        this.manufacturer = manufacturer;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

}
