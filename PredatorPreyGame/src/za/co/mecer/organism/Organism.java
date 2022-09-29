package za.co.mecer.organism;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.dooglebugs.DoogleBugs;

/**
 *
 * @author Dimakatso Sebatane
 */
public abstract class Organism implements Organisms {

    private Organism orgAd;
    private int xCor, yCor, steps = 0;

    public Organism() {

    }

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

    @Override
    public void moveUp(Organisms[][] orgs, Organism org) {
        orgAd = (Organism) (orgs[getXCor()][getYCor()]);
        if (((getXCor() - 1 >= 0) && (orgs[getXCor() - 1][getYCor()] == null))
                || (org instanceof DoogleBugs && (getXCor() - 1 >= 0) && orgs[getXCor() - 1][getYCor()] instanceof Ants)) {
            org.setXCor(getXCor() - 1);
            org.setYCor(getYCor());
            if (orgAd.getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(orgAd.getSteps() + 1);
            }
            orgs[getXCor() - 1][getYCor()] = org;
            orgs[getXCor()][getYCor()] = null;
        }

    }

    @Override
    public void moveDown(Organisms[][] orgs, Organism org) {
        orgAd = (Organism) (orgs[getXCor()][getYCor()]);
        if (((getXCor() + 1 < orgs.length) && (orgs[getXCor() + 1][getYCor()] == null))
                || (org instanceof DoogleBugs && (getXCor() + 1 < orgs.length) && orgs[getXCor() + 1][getYCor()] instanceof Ants)) {
            org.setXCor(getXCor() + 1);
            org.setYCor(getYCor());
            if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(orgAd.getSteps() + 1);
            }
            orgs[getXCor() + 1][getYCor()] = org;
            orgs[getXCor()][getYCor()] = null;
            //   right = true;
        }

    }

    @Override
    public void moveLeft(Organisms[][] orgs, Organism org) {
        orgAd = (Organism) orgs[getXCor()][getYCor()];

        if (((getYCor() - 1 >= 0) && (orgs[getXCor()][getYCor() - 1] == null))
                || (org instanceof DoogleBugs && (getYCor() - 1 >= 0) && orgs[getXCor()][getYCor() - 1] instanceof Ants)) {
            org.setXCor(getXCor());
            org.setYCor(getYCor() - 1);
            if (orgAd.getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(orgAd.getSteps() + 1);
            }

            orgs[getXCor()][getYCor() - 1] = org;
            orgs[getXCor()][getYCor()] = null;
            // up = true;
        }

    }

    @Override
    public void moveRight(Organisms[][] orgs, Organism org) {
        orgAd = (Organism) orgs[getXCor()][getYCor()];
        if (((getYCor() + 1 < orgs.length) && (orgs[getXCor()][getYCor() + 1] == null))
                || (org instanceof DoogleBugs && (getYCor() + 1 < orgs.length) && orgs[getXCor()][getYCor() + 1] instanceof Ants)) {
            org.setXCor(getXCor());
            org.setYCor(getYCor() + 1);
            if (orgAd.getSteps() >= 3) {
                org.setSteps(0);
            } else {
                org.setSteps(orgAd.getSteps() + 1);
            }
            orgs[getXCor()][getYCor() + 1] = org;
            orgs[getXCor()][getYCor()] = null;
            // down = true;

        }
    }

}
