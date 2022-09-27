package za.co.mecer.organism.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Organisms {

    void move(Organisms[][] org);

    void breed(Organisms[][] org);

    int getSteps();

    void setSteps(int steps);

    void setXCor(int xCor);

    int getXCor();

    void setYCor(int yCor);

    int getYCor();
}
