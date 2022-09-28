package za.co.mecer.organism.ants;

import za.co.mecer.impl.Organisms;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.directions.Directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Ants extends Organism {

    boolean up, down, left, right;

    public Ants(int xCor, int yCor) {
        super(xCor, yCor);
    }

    @Override
    public void move(Organisms[][] orgs) {
        int random = (int) (Math.random() * 4);
        Directions[] dir = Directions.values();
        //Remember to set the steps of the new ant when moving 
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
        orgs[getXCor()][getYCor()] = null;
    }

    @Override
    public void breed(Organisms[][] orgs) {
        int steps = orgs[getXCor()][getYCor()].getSteps();
        System.out.println("Steps: " + steps);
        if (steps == 3) {
            moveUp(orgs);
            if (!up) {
                moveDown(orgs);
            } else if (!down) {
                moveLeft(orgs);
            } else if (!left) {
                moveRight(orgs);
            }
            orgs[getXCor()][getYCor()].setSteps(0);
        }
    }

    @Override
    public void moveUp(Organisms[][] orgs) {
        if (getYCor() - 1 >= 0) {
            if (orgs[getXCor()][getYCor() - 1] == null) {
                Ants ant = new Ants(getXCor(), getYCor() - 1);
                if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                    ant.setSteps(0);
                } else {
                    ant.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                }

                orgs[getXCor()][getYCor() - 1] = ant;

            }

        }
    }

    @Override
    public void moveDown(Organisms[][] orgs) {
        if (getYCor() + 1 <= 4) {
            if (orgs[getXCor()][getYCor() + 1] == null) {
                Ants ant = new Ants(getXCor(), getYCor() + 1);
                if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                    ant.setSteps(0);
                } else {
                    ant.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                }
                orgs[getXCor()][getYCor() + 1] = ant;
                down = true;
            }

        }
    }

    @Override
    public void moveLeft(Organisms[][] orgs) {
        if (getXCor() - 1 >= 0) {
            if (orgs[getXCor() - 1][getYCor()] == null) {
                Ants ant = new Ants(getXCor() - 1, getYCor());
                if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                    ant.setSteps(0);
                } else {
                    ant.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                }
                orgs[getXCor() - 1][getYCor()] = ant;
                left = true;
            }
        }
    }

    @Override
    public void moveRight(Organisms[][] orgs) {
        if (getXCor() + 1 <= 4) {
            if (orgs[getXCor() + 1][getYCor()] == null) {
                Ants ant = new Ants(getXCor() + 1, getYCor());
                if (orgs[getXCor()][getYCor()].getSteps() >= 3) {
                    ant.setSteps(0);
                } else {
                    ant.setSteps(orgs[getXCor()][getYCor()].getSteps() + 1);
                }
                orgs[getXCor() + 1][getYCor()] = ant;
                right = true;
            }
        }
    }

}
