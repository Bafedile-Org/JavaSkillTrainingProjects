package za.co.mecer.organism.dooglebugs;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.directions.Directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DoogleBugs extends Organism {

    private boolean eaten = false, breed = false;

    public DoogleBugs() {

    }

    public DoogleBugs(int xCor, int yCor) {
        super(xCor, yCor);
    }

    @Override
    public void move(Organisms[][] orgs) {
        int random = (int) (Math.random() * 4);
        Directions[] dir = Directions.values();
        //Remember to set the steps of the new bug when moving 
        switch (dir[random]) {
            case UP:
                moveUp(orgs, new DoogleBugs());
                break;
            case DOWN:
                moveDown(orgs, new DoogleBugs());
                break;
            case LEFT:
                moveLeft(orgs, new DoogleBugs());
                break;

            default:
                moveRight(orgs, new DoogleBugs());
                break;

        }
        //breed(orgs);
        starve(orgs);
    }

    @Override
    public void breed(Organisms[][] orgs) {
        if (getSteps() == 8) {
            setBreed(true);
            while (!getMove()) {
                move(orgs);
            }
            setSteps(0);
        }
    }

    public void starve(Organisms[][] org) {
        if (org[getXCor()][getYCor()] != null && org[getXCor()][getYCor()].getSteps() == 3 && eaten == false) {
            org[getXCor()][getYCor()] = null;
        }
    }

}
