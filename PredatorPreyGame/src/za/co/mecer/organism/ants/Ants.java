package za.co.mecer.organism.ants;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.directions.Directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Ants extends Organism {

    boolean up, down, left, right;

    boolean breed;

    public Ants() {
    }

    public Ants(int xCor, int yCor) {
        super(xCor, yCor);
    }

    @Override
    public void move(Organisms[][] orgs) {
        int random = (int) (Math.random() * 4);
        Directions[] dir = Directions.values();
        //Remember to set the steps of the new ant when moving 
        switch (dir[random]) {
            case UP:
                moveUp(orgs, new Ants());
                break;
            case DOWN:
                moveDown(orgs, new Ants());
                break;
            case LEFT:
                moveLeft(orgs, new Ants());
                break;
            default:
                moveRight(orgs, new Ants());
                break;
        }
        //  breed(orgs);
//        orgs[getXCor()][getYCor()] = null;
    }

//    @Override
//    public void breed(Organisms[][] orgs) {
//
//        setBreed(true);
//        while (getMove()) {
//            move(orgs);
//        }
//        setSteps(0);
//    }
    @Override
    public void setBreed(Organism org) {
        if (org.getSteps() == 3) {
            breed = true;
        }

    }

    @Override
    public void breed(Organisms[][] orgs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
