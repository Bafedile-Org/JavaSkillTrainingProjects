
package za.co.mecer.product.impl;

import za.co.mecer.product.Product;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Furniture implements  Product{

    @Override
    public float getPrice() {
        return 5689.98f;
    }

    @Override
    public String getName() {
        return "Beautiful Dinning Room Set";
    }
   
    @Override
    public String toString(){
        return String.format("Funiture");
    }

    @Override
    public void hello() {
        System.out.println("Hello I am a furniture");
    }
    
}
