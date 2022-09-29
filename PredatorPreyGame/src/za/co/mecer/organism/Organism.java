package za.co.mecer.organism;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.dooglebugs.DoogleBugs;

/**
 *
 * @author Dimakatso Sebatane
 */
public abstract class Organism implements Organisms {

    private int xCor, yCor, steps = 0;
    private boolean breed, move;

    public Organism() {
        this.breed = false;
    }

    public Organism(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
        this.breed = false;
    }

    @Override
    public void setBreed(boolean breed) {
        this.breed = breed;
    }

    @Override
    public boolean getBreed() {
        return breed;
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

    @Override
    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean getMove() {
        return move;
    }

    public boolean getMoveUp(Organisms[][] orgs, Organism org) {
        return ((getXCor() - 1 >= 0) && (orgs[getXCor() - 1][getYCor()] == null))
                || (org instanceof DoogleBugs && (getXCor() - 1 >= 0)
                && orgs[getXCor() - 1][getYCor()] instanceof Ants);
    }

    public boolean getMoveDown(Organisms[][] orgs, Organism org) {
        return ((getXCor() + 1 < orgs.length) && (orgs[getXCor() + 1][getYCor()] == null))
                || (org instanceof DoogleBugs && (getXCor() + 1 < orgs.length)
                && orgs[getXCor() + 1][getYCor()] instanceof Ants);
    }

    public boolean getMoveLeft(Organisms[][] orgs, Organism org) {
        return ((getYCor() - 1 >= 0) && (orgs[getXCor()][getYCor() - 1] == null))
                || (org instanceof DoogleBugs && (getYCor() - 1 >= 0)
                && orgs[getXCor()][getYCor() - 1] instanceof Ants);
    }

    public boolean getMoveRight(Organisms[][] orgs, Organism org) {
        return ((getYCor() + 1 < orgs.length) && (orgs[getXCor()][getYCor() + 1] == null))
                || (org instanceof DoogleBugs && (getYCor() + 1 < orgs.length)
                && orgs[getXCor()][getYCor() + 1] instanceof Ants);
    }

    @Override
    public void moveUp(Organisms[][] orgs, Organism org) {
        if (getMoveUp(orgs, org)) {
            org.setXCor(getXCor() - 1);
            org.setYCor(getYCor());
            if (getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(getSteps() + 1);
            }
            orgs[getXCor() - 1][getYCor()] = org;
            setMove(true);
            setBreed(org);
        }
        if (getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
            setMove(false);

        }
        if (org.getBreed()) {

        }

    }

    @Override
    public void moveDown(Organisms[][] orgs, Organism org) {
        if (getMoveDown(orgs, org)) {
            org.setXCor(getXCor() + 1);
            org.setYCor(getYCor());
            if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(getSteps() + 1);
            }
            orgs[getXCor() + 1][getYCor()] = org;
            setMove(true);
            setBreed(org);

        }
        if (getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
            setMove(false);

        }

    }

    @Override
    public void moveLeft(Organisms[][] orgs, Organism org) {

        if (getMoveLeft(orgs, org)) {
            org.setXCor(getXCor());
            org.setYCor(getYCor() - 1);
            if (getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(getSteps() + 1);
            }

            orgs[getXCor()][getYCor() - 1] = org;
            setMove(true);
            setBreed(org);

        }
        if (getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
            setMove(false);

        }

    }

    @Override
    public void moveRight(Organisms[][] orgs, Organism org) {
        if (getMoveRight(orgs, org)) {
            org.setXCor(getXCor());
            org.setYCor(getYCor() + 1);
            if (getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(getSteps() + 1);
            }
            orgs[getXCor()][getYCor() + 1] = org;
            setMove(true);
            setBreed(org);

        }
        if (getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
            setMove(false);

        }

    }

}
