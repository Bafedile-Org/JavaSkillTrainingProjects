package za.co.mecer.impl;

import za.co.mecer.organism.Organism;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Organisms {

    void move(Organism[][] orgs, Organism org);

    void doMove(Organism[][] orgs);

    void moveUp(Organism[][] orgs, Organism org);

    void moveDown(Organism[][] orgs, Organism org);

    void moveLeft(Organism[][] orgs, Organism org);

    void moveRight(Organism[][] orgs, Organism org);

    void breed(Organism[][] orgs);

    public boolean getBreed();

    public void determineBreed(Organism org);

    public void setBreed(boolean breed);

    public void setMove(boolean move);

    public boolean getMove();

    int getSteps();

    void setSteps(int steps);

    void setXCor(int xCor);

    int getXCor();

    void setYCor(int yCor);

    int getYCor();

}
