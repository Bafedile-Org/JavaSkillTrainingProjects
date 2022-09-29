package za.co.mecer.organism.dooglebugs;

import za.co.mecer.organism.Organism;

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
    public void doMove(Organism[][] orgs) {
        move(orgs, new DoogleBugs());
    }

    public boolean starve(Organism[][] orgs, Organism org) {
        if (((DoogleBugs) org).getSteps() == 3 && !((DoogleBugs) org).getEaten()) {
            System.out.printf("-------------------------------\n"
                    + "DOOGLEBUG [%d][%d] STARVED TO DEATH\n"
                    + "-------------------------------\n", ((DoogleBugs) org).getXCor(),
                    ((DoogleBugs) org).getYCor());
            return true;

        }
        return false;
    }

    public void setEaten(boolean starve) {
        eaten = true;
    }

    public boolean getEaten() {
        return eaten;
    }

    @Override
    public void determineBreed(Organism org) {
        if (org.getSteps() == 8) {
            org.setBreed(true);
        }
    }
}
