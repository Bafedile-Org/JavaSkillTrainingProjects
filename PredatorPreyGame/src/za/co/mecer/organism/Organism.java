package za.co.mecer.organism;

import za.co.mecer.impl.Organisms;

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

    @Override
    public int getSteps() {
        return steps;
    }

    @Override
    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public void setXCor(int xCor) {
        this.xCor = xCor;
    }

    @Override
    public int getXCor() {
        return xCor;
    }

    @Override
    public void setYCor(int yCor) {
        this.yCor = yCor;
    }

    @Override
    public int getYCor() {
        return yCor;
    }
}
