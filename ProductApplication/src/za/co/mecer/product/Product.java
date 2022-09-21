package za.co.mecer.product;

import za.co.mecer.interfaces.product.ProductInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Product implements ProductInterface {

    private double regularPrice;

    public Product(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    @Override
    public double computeSalePrice() {
        return 0;
    }

    @Override
    public double getRegularPrice() {
        return regularPrice;
    }

    @Override
    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }
}
