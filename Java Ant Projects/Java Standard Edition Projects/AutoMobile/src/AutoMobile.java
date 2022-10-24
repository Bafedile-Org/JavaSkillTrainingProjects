/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class AutoMobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Car car1 = new Car();
       Car car2 = new Car("BMW","X Series",40);
       
        System.out.println(car1.toString());
        System.out.println("\n===========================================\n");
        System.out.println(car2.toString());

    }
    
    
}
