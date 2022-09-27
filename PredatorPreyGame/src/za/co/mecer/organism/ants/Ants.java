package za.co.mecer.organism.ants;

import za.co.mecer.organism.Organism;
import za.co.mecer.organism.directions.Directions;
import za.co.mecer.organism.impl.Organisms;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Ants extends Organism {

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
                if (getYCor() - 1 >= 0) {
                    if (orgs[getXCor()][getYCor() - 1] == null) {
                        Ants ant = new Ants(getXCor(), getYCor() - 1);
                        ant.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() - 1] = ant;
                        orgs[getXCor()][getYCor()] = null;
                    }

                }
                break;
            case DOWN:
                if (getYCor() + 1 <= 4) {
                    if (orgs[getXCor()][getYCor() + 1] == null) {
                        Ants ant = new Ants(getXCor(), getYCor() + 1);
                        ant.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor()][getYCor() + 1] = ant;
                        orgs[getXCor()][getYCor()] = null;
                    }

                }
                break;
            case LEFT:
                if (getXCor() - 1 >= 0) {
                    if (orgs[getXCor() - 1][getYCor()] == null) {
                        Ants ant = new Ants(getXCor() - 1, getYCor());
                        ant.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() - 1][getYCor()] = ant;
                        orgs[getXCor()][getYCor()] = null;
                    }
                }
                break;

            default:
                if (getXCor() + 1 <= 4) {
                    if (orgs[getXCor() + 1][getYCor()] == null) {
                        Ants ant = new Ants(getXCor() + 1, getYCor());
                        ant.setSteps(orgs[getXCor()][getYCor()].getSteps());
                        orgs[getXCor() + 1][getYCor()] = ant;
                        orgs[getXCor()][getYCor()] = null;
                    }
                }
                break;

        }
    }

    @Override
    public void breed(Organisms[][] org) {

    }

}
