package za.co.mecer.game;

import za.co.mecer.impl.Gaming;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.dooglebugs.DoogleBugs;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Game implements Gaming {

    Organism[][] orgs = new Organism[5][5];

    public void play() {
        populateWorldGrid();
        do {
            displayGrid();
            moveAnts();
            displayGrid();
            checkBreed();
            displayGrid();
            moveBugs();
        } while (checkPopulation());
//        displayGrid();
    }

    private void populateWorldGrid() {
        System.out.println("Please be patient while populating the World Grid");
        populateAnts();
        populateBugs();

    }

    private void checkBreed() {
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    org1.breed(orgs);
                }
                if (org1 instanceof DoogleBugs) {
                    org1.breed(orgs);
                }
            }
        }
    }

    private boolean checkPopulation() {
        boolean ants = false, bugs = false;
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    ants = true;
                }
                if (org1 instanceof DoogleBugs) {
                    bugs = true;
                }
            }
        }
        return ants && bugs;
    }

    private void moveAnts() {
        System.out.println("\n");
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    org1.move(orgs);
                }
            }
        }
    }

    private void moveBugs() {
        System.out.println("\n");
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof DoogleBugs) {
                    org1.move(orgs);
                }
            }
        }
    }

    private void populateAnts() {
        int antsCount = 0, x, y;
        while (antsCount < ANTS_NUM) {
            x = randomNumber();
            y = randomNumber();
            if (orgs[x][y] == null) {
                orgs[x][y] = new Ants(x, y);
                antsCount++;
            }
        }
    }

    private void populateBugs() {
        int bugsCount = 0, x, y;
        while (bugsCount < BUGS_NUM) {

            x = randomNumber();
            y = randomNumber();
            if (orgs[x][y] == null) {
                orgs[x][y] = new DoogleBugs(x, y);
                bugsCount++;
            }
        }
    }

    private int randomNumber() {
        int rand = (int) (Math.random() * orgs.length);
        return rand;
    }

    private void displayGrid() {
        System.out.println("\n--------------------------------------------------------");
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    System.out.print(String.format("%-10s", " 0 "));
                } else if (org1 instanceof DoogleBugs) {
                    System.out.print(String.format("%-10s", " X "));
                } else {
                    System.out.print(String.format("%-10s", " * "));
                }
            }
            System.out.println("\n");
        }
        System.out.println("--------------------------------------------------------");
    }

}
