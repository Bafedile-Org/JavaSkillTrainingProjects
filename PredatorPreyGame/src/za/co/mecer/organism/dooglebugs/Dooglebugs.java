package za.co.mecer.organism.dooglebugs;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.directions.Directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DoogleBugs extends Organism {

    private boolean eaten = false;

    public DoogleBugs(int xCor, int yCor) {
        super(xCor, yCor);
    }

    @Override
    public void moveRight(Organisms[][] orgs) {
        if (getYCor() - 1 >= 0) {
            if (orgs[getXCor()][getYCor() - 1] == null) {
                DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() - 1);
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor()][getYCor() - 1] = bug;
                orgs[getXCor()][getYCor()] = null;
            }

            if (orgs[getXCor()][getYCor() - 1] instanceof Ants) {
                DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() - 1);
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor()][getYCor() - 1] = bug;
                orgs[getXCor()][getYCor()] = null;
                eaten = true;
            }

        }
    }

    @Override
    public void moveLeft(Organisms[][] orgs) {
        if (getYCor() + 1 < orgs.length) {
            if (orgs[getXCor()][getYCor() + 1] == null) {
                DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() + 1);
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor()][getYCor() + 1] = bug;
                orgs[getXCor()][getYCor()] = null;
            }
            if (orgs[getXCor()][getYCor() + 1] instanceof Ants) {
                DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() + 1);
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor()][getYCor() + 1] = bug;
                orgs[getXCor()][getYCor()] = null;
                eaten = true;

            }

        }
    }

    @Override
    public void moveDown(Organisms[][] orgs) {
        if (getXCor() - 1 >= 0) {
            if (orgs[getXCor() - 1][getYCor()] == null) {
                DoogleBugs bug = new DoogleBugs(getXCor() - 1, getYCor());
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor() - 1][getYCor()] = bug;
                orgs[getXCor()][getYCor()] = null;
            }
            if (orgs[getXCor() - 1][getYCor()] instanceof Ants) {
                DoogleBugs bug = new DoogleBugs(getXCor() - 1, getYCor());
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor() - 1][getYCor()] = bug;
                orgs[getXCor()][getYCor()] = null;
                eaten = true;

            }
        }
    }

    @Override
    public void moveUp(Organisms[][] orgs) {
        if (getXCor() + 1 < orgs.length) {
            if (orgs[getXCor() + 1][getYCor()] == null) {
                DoogleBugs bug = new DoogleBugs(getXCor() + 1, getYCor());
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor() + 1][getYCor()] = bug;
                orgs[getXCor()][getYCor()] = null;
            }
            if (orgs[getXCor() + 1][getYCor()] instanceof Ants) {
                DoogleBugs bug = new DoogleBugs(getXCor() + 1, getYCor());
                bug.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                orgs[getXCor() + 1][getYCor()] = bug;
                orgs[getXCor()][getYCor()] = null;
                eaten = true;

            }
        }
    }

    @Override
    public void move(Organisms[][] orgs) {
        int random = (int) (Math.random() * 4);
        Directions[] dir = Directions.values();
        //Remember to set the steps of the new bug when moving 
        switch (dir[random]) {
            case UP:
                moveUp(orgs);
                break;
            case DOWN:
                moveDown(orgs);
                break;
            case LEFT:
                moveLeft(orgs);
                break;

            default:
                moveRight(orgs);
                break;

        }
//        breed(orgs);
        starve(orgs);
    }

    @Override
    public void breed(Organisms[][] org) {
    }

    public void starve(Organisms[][] org) {
        if (org[getXCor()][getYCor()] != null && org[getXCor()][getYCor()].getSteps() == 8 && eaten == false) {
            org[getXCor()][getYCor()] = null;
        }
    }

}
