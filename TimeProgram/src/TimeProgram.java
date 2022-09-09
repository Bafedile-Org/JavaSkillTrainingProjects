/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class TimeProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int time = 50391;
        System.out.printf("Time is: %d:%d:%d%n",((time/3600)%60),((time/60)%60),((time/3600)%3600));        
    }
    
}
