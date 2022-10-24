package za.co.mecer.organism.ants;

import za.co.mecer.organism.Organism;

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
    public void doMove(Organism[][] orgs) {
        move(orgs, new Ants());
    }

    @Override
    public void determineBreed(Organism org) {
        if (org.getSteps() == 3) {
            org.setBreed(true);
        }
    }

}
