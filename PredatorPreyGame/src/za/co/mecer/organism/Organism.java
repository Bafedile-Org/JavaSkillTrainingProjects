package za.co.mecer.organism;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.directions.Directions;
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
    public boolean getBreed() {
        return breed;
    }

    @Override
    public void setBreed(boolean breed) {
        this.breed = breed;
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

    @Override
    public boolean getMove() {
        return move;
    }

    @Override
    public void breed(Organism[][] orgs) {
        if (getBreed()) {

            if (getAntInstance(this)) {
                System.out.printf("-------------------------------\n"
                        + "ANT AT [%d][%d] BRED\n"
                        + "-------------------------------\n", getXCor(), getYCor());
            }

            if (getBugInstance(this)) {
                System.out.printf("-------------------------------\n"
                        + "DOOGLEBUG AT [%d][%d] BRED\n"
                        + "-------------------------------\n", getXCor(), getYCor());
            }
            setBreed(false);
            doMove(orgs);

        }
    }

    public boolean getMoveUp(Organism[][] orgs, Organism org) {
        if ((getXCor() - 1 >= 0)) {
            return (orgs[getXCor() - 1][getYCor()] == null)
                    || (getBugInstance(org) && (getXCor() - 1 >= 0)
                    && getAntInstance(orgs[getXCor() - 1][getYCor()]));
        }
        return false;
    }

    public boolean getMoveDown(Organism[][] orgs, Organism org) {
        if ((getXCor() + 1) < orgs.length) {
            return (orgs[getXCor() + 1][getYCor()] == null)
                    || (getBugInstance(org) && ((getXCor() + 1) < orgs.length)
                    && getAntInstance(orgs[getXCor() + 1][getYCor()]));
        }
        return false;
    }

    public boolean getMoveLeft(Organism[][] orgs, Organism org) {
        if ((getYCor() - 1 >= 0)) {
            return (orgs[getXCor()][getYCor() - 1] == null)
                    || (getBugInstance(org) && (getYCor() - 1 >= 0)
                    && getAntInstance(orgs[getXCor()][getYCor() - 1]));

        }
        return false;
    }

    public boolean getMoveRight(Organism[][] orgs, Organism org) {
        if ((getYCor() + 1 < orgs.length)) {
            return (orgs[getXCor()][getYCor() + 1] == null)
                    || (getBugInstance(org) && (getYCor() + 1 < orgs.length)
                    && getAntInstance(orgs[getXCor()][getYCor() + 1]));
        }
        return false;
    }

    public boolean getBugInstance(Organism org) {
        return org instanceof DoogleBugs;
    }

    public boolean getAntInstance(Organism org) {
        return org instanceof Ants;
    }

    public void setEaten(Organism ant, Organism bug) {

        if (getAntInstance(ant) && getBugInstance(bug)) {
            ((DoogleBugs) bug).setEaten(true);
        }

    }

    public void setStarve(Organism[][] orgs, Organism org) {

        if (getBugInstance(org)) {
            if (((DoogleBugs) org).starve(orgs, org)) {
                orgs[getXCor()][getYCor()] = null;
            }
        }

    }

    @Override
    public void moveUp(Organism[][] orgs, Organism org) {
        if (getMoveUp(orgs, org)) {
            org.setXCor(getXCor() - 1);
            org.setYCor(getYCor());
            setEaten(orgs[getXCor() - 1][getYCor()], this);

            if (!this.getBreed()) {
                if (getSteps() >= 3) {
                    org.setSteps(0);
                } else {
                    org.setSteps(getSteps() + 1);
                }
            }
            orgs[getXCor() - 1][getYCor()] = org;
            org.setMove(true);
            org.determineBreed(org);
            org.setStarve(orgs, this);

        }

        if (org.getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;

        }

    }

    @Override
    public void moveDown(Organism[][] orgs, Organism org) {
        if (getMoveDown(orgs, org)) {
            org.setXCor(getXCor() + 1);
            org.setYCor(getYCor());

            setEaten(orgs[getXCor() + 1][getYCor()], this);

            if (!getBreed()) {
                if (getSteps() >= 3) {
                    org.setSteps(0);
                } else {
                    org.setSteps(getSteps() + 1);
                }
            }
            orgs[getXCor() + 1][getYCor()] = org;
            org.setMove(true);
            org.determineBreed(org);
            org.setStarve(orgs, this);

        }
        if (org.getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;

        }

    }

    @Override
    public void moveLeft(Organism[][] orgs, Organism org) {

        if (getMoveLeft(orgs, org)) {

            org.setXCor(getXCor());
            org.setYCor(getYCor() - 1);

            setEaten(orgs[getXCor()][getYCor() - 1], this);

            if (!this.getBreed()) {
                if (getSteps() >= 3) {
                    org.setSteps(0);
                } else {
                    org.setSteps(getSteps() + 1);
                }
            }

            orgs[getXCor()][getYCor() - 1] = org;
            org.setMove(true);
            org.determineBreed(org);
            org.setStarve(orgs, this);

        }
        if (org.getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
        }

    }

    @Override
    public void moveRight(Organism[][] orgs, Organism org) {
        if (getMoveRight(orgs, org)) {
            org.setXCor(getXCor());
            org.setYCor(getYCor() + 1);

            setEaten(orgs[getXCor()][getYCor() + 1], this);

            if (!this.getBreed()) {
                if (getSteps() >= 3) {
                    org.setSteps(0);
                } else {
                    org.setSteps(getSteps() + 1);
                }
            }
            orgs[getXCor()][getYCor() + 1] = org;
            org.setMove(true);
            org.determineBreed(org);
            org.setStarve(orgs, this);

        }

        if (org.getMove() && !org.getBreed()) {
            orgs[getXCor()][getYCor()] = null;
        }

    }

    @Override
    public void move(Organism[][] orgs, Organism org) {
        Organism orgC = org;
        boolean isValid = false, up = false, down = false, left = false, right;
        Directions[] dir = Directions.values();
        loop:
        while (!isValid) {
            int random = (int) (Math.random() * 4);
            //Remember to set the steps of the new ant when moving 
            switch (dir[random]) {
                case UP:
                    moveUp(orgs, orgC);
                    up = true;
                    if (orgC.getMove()) {
                        isValid = true;
                        break loop;
                    }

                    break;
                case DOWN:
                    moveDown(orgs, orgC);
                    down = true;
                    if (orgC.getMove()) {
                        isValid = true;
                        break loop;
                    }

                    break;
                case LEFT:
                    moveLeft(orgs, orgC);
                    left = true;
                    if (orgC.getMove()) {
                        isValid = true;
                        break loop;
                    }

                    break;
                default:
                    moveRight(orgs, orgC);
                    right = true;
                    if (orgC.getMove()) {
                        isValid = true;
                        break loop;
                    }
                    if (!(up && down && left && right)) {
                        break;
                    } else {
                        isValid = true;
                        break loop;
                    }
            }

        }
    }

}
