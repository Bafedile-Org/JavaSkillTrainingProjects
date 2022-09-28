package za.co.mecer.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Organisms {

    void move(Organisms[][] orgs);

    void moveUp(Organisms[][] orgs);

    void moveDown(Organisms[][] orgs);

    void moveLeft(Organisms[][] orgs);

    void moveRight(Organisms[][] orgs);

    void breed(Organisms[][] org);

    int getSteps();

    void setSteps(int steps);

    void setXCor(int xCor);

    int getXCor();

    void setYCor(int yCor);

    int getYCor();

}
