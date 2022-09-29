package za.co.mecer.impl;

import za.co.mecer.organism.Organism;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Organisms {

    void move(Organisms[][] orgs);

    void moveUp(Organisms[][] orgs, Organism org);

    void moveDown(Organisms[][] orgs, Organism org);

    void moveLeft(Organisms[][] orgs, Organism org);

    void moveRight(Organisms[][] orgs, Organism org);

    void breed(Organisms[][] orgs);
//    void breed(Organisms[][] orgs, Organisms org);

    public boolean getBreed();

    public void setBreed(Organism org);

    public void setMove(boolean move);

    public boolean getMove();

    int getSteps();

    void setSteps(int steps);

    void setXCor(int xCor);

    int getXCor();

    void setYCor(int yCor);

    int getYCor();

}
