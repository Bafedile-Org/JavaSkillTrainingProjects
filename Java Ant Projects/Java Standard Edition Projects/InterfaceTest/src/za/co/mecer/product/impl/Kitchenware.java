
package za.co.mecer.product.impl;

import za.co.mecer.product.Product;

/**
 * @author Dimakatso Bafedile Sebatane
 */
public class Kitchenware implements Product{

    @Override
    public float getPrice() {
        return 78.43f;
    }

    @Override
    public String getName() {
        return "Set of copper pots";
    }
    
    @Override
    public String toString(){
        return String.format("Kitchenware");
    }

    @Override
    public void hello() {
        System.out.println("Hello I am a kitchenware");
    }
    
}
