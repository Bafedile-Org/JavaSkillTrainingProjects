package za.co.mecer.organism;

import za.co.mecer.organism.impl.Organisms;

/**
 *
 * @author Dimakatso Sebatane
 */
public abstract class Organism implements Organisms {

    private int xCor, yCor, steps = 0;

    public Organism(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setXCor(int xCor) {
        this.xCor = xCor;
    }

    public int getXCor() {
        return xCor;
    }

    public void setYCor(int yCor) {
        this.yCor = yCor;
    }

    public int getYCor() {
        return yCor;
    }
}
