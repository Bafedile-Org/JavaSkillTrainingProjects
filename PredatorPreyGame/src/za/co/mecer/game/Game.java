package za.co.mecer.game;

import za.co.mecer.organism.Organism;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.dooglebugs.DoogleBugs;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Game {

    Organism[][] orgs = new Organism[6][6];

    public void play() {
        populateWorldGrid();
        do {
            displayGrid();
            moveAnts();
            moveBugs();
            displayGrid();

        } while (checkPopulation());
    }

    private void populateWorldGrid() {
        System.out.println("Please be patient while populating the World Grid");
        populateAnts();
        populateBugs();

    }

    private boolean checkPopulation() {
        boolean ants = false, bugs = false;
        for (int i = 0; i < orgs.length; i++) {
            for (int j = 0; j < orgs[i].length; j++) {
                if (orgs[i][j] instanceof Ants) {
                    ants = true;
                }
                if (orgs[i][j] instanceof DoogleBugs) {
                    bugs = true;
                }
            }
        }
        return ants && bugs;
    }

    private void moveAnts() {
        System.out.println("\n");
        for (int i = 0; i < orgs.length; i++) {
            for (int j = 0; j < orgs[i].length; j++) {
                if (orgs[i][j] instanceof Ants) {
                    orgs[i][j].move(orgs);
                }
            }
        }
    }

    private void moveBugs() {
        System.out.println("\n");
        for (int i = 0; i < orgs.length; i++) {
            for (int j = 0; j < orgs[i].length; j++) {
                if (orgs[i][j] instanceof DoogleBugs) {
                    orgs[i][j].move(orgs);
                }
            }
        }
    }

    private void populateAnts() {
        int antsCount = 0, x, y;
        while (antsCount < 30) {
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
        while (bugsCount < 5) {

            x = randomNumber();
            y = randomNumber();
            if (orgs[x][y] == null) {
                orgs[x][y] = new DoogleBugs(x, y);
                bugsCount++;
            }
        }
    }

    private int randomNumber() {
        int rand = (int) (Math.random() * 5);
        return rand;
    }

    private void displayGrid() {
        System.out.println("\n");
        for (int i = 0; i < orgs.length; i++) {
            for (int j = 0; j < orgs[i].length; j++) {
                if (orgs[i][j] instanceof Ants) {
                    System.out.print(String.format("%-10s", " 0 "));
                } else if (orgs[i][j] instanceof DoogleBugs) {
                    System.out.print(String.format("%-10s", " X "));

                } else {
                    System.out.print(String.format("%-10s", " * "));

                }

            }
            System.out.println();
        }
    }

}
