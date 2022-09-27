package za.co.mecer.organism.dooglebugs;

import za.co.mecer.organism.Organism;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.directions.Directions;
import za.co.mecer.organism.impl.Organisms;

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
    public void move(Organisms[][] orgs) {
        int random = (int) (Math.random() * 4);
        Directions[] dir = Directions.values();
        //Remember to set the steps of the new bug when moving 
        switch (dir[random]) {
            case UP:
                if (getYCor() - 1 >= 0) {
                    if (orgs[getXCor()][getYCor() - 1] == null) {
                        DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() - 1);
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() - 1] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }

                    if (orgs[getXCor()][getYCor() - 1] instanceof Ants) {
                        DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() - 1);
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() - 1] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }

                }
                break;
            case DOWN:
                if (getYCor() + 1 <= 4) {
                    if (orgs[getXCor()][getYCor() + 1] == null) {
                        DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() + 1);
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() + 1] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }
                    if (orgs[getXCor()][getYCor() + 1] instanceof Ants) {
                        DoogleBugs bug = new DoogleBugs(getXCor(), getYCor() + 1);
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() + 1] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }

                }
                break;
            case LEFT:
                if (getXCor() - 1 >= 0) {
                    if (orgs[getXCor() - 1][getYCor()] == null) {
                        DoogleBugs bug = new DoogleBugs(getXCor() - 1, getYCor());
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() - 1][getYCor()] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }
                    if (orgs[getXCor() - 1][getYCor()] instanceof Ants) {
                        DoogleBugs bug = new DoogleBugs(getXCor() - 1, getYCor());
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() - 1][getYCor()] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }
                }
                break;

            default:
                if (getXCor() + 1 <= 4) {
                    if (orgs[getXCor() + 1][getYCor()] == null) {
                        DoogleBugs bug = new DoogleBugs(getXCor() + 1, getYCor());
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() + 1][getYCor()] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }
                    if (orgs[getXCor() + 1][getYCor()] instanceof Ants) {
                        DoogleBugs bug = new DoogleBugs(getXCor() + 1, getYCor());
                        bug.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() + 1][getYCor()] = bug;
                        orgs[getXCor()][getYCor()] = null;
                    }
                }
                break;

        }
//        breed(orgs);
//        starve(orgs);
    }

    @Override
    public void breed(Organisms[][] org) {
    }

    public void starve(Organisms[][] org) {
        if (org[getXCor()][getYCor()].getSteps() == 8 && eaten == false) {
            org[getXCor()][getYCor()] = null;
        }
    }

}
