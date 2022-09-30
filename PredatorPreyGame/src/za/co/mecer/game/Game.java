package za.co.mecer.game;

import java.util.Scanner;
import za.co.mecer.game.exceptions.GameException;
import za.co.mecer.impl.Gaming;
import za.co.mecer.organism.Organism;
import za.co.mecer.organism.ants.Ants;
import za.co.mecer.organism.dooglebugs.DoogleBugs;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Game implements Gaming {

    final Organism[][] orgs = new Organism[GRID_LENGTH][GRID_LENGTH];

    int i = 0;
    Scanner input = new Scanner(System.in);

    public Game() {
        populateWorldGrid();
    }

    public int getChoice() {
        int choice = 0, option;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("Choose Playing Options\n"
                        + "1  AutoPlay\n"
                        + "2  Manual Play\n"
                        + "Your choice: ");
                choice = input.nextInt();
                if (choice < 1 && choice > 2) {
                    throw new GameException("Choose between 1 and 2\n");
                }
            } catch (GameException ge) {
                System.out.printf("Error: %s%n", ge.getMessage());
            }
        } while (choice < 1 && choice > 2);

        return choice;
    }

    public void play() {

        int choice = getChoice(), enKey;
        int x, y;
        if (choice == 1) {
            while (checkPopulation()) {

                displayGrid();
                moveOrganisms();
            }
        } else {
            displayGrid();
            do {
                System.out.println("Press Enter  to continue");
                String str = input.nextLine();
                if (str.isEmpty() || str.charAt(0) == '0') {
                    enKey = 0;
                } else {
                    enKey = 1;
                }
                x = (int) (Math.random() * GRID_LENGTH);
                y = (int) (Math.random() * GRID_LENGTH);
                if (orgs[x][y] != null) {
                    orgs[x][y].doMove(orgs);
                    displayGrid();
                }
            } while (enKey != 1);
        }
    }

    private void populateWorldGrid() {
        try {
            displayIntro();

            populateAnts();
            populateBugs();
        } catch (InterruptedException ex) {
            System.out.printf("%nError: %s%n", ex.getMessage());
        }

    }

    private void displayIntro() throws InterruptedException {
        String intro = "Predation is a key system in the life cycle.\n"
                + "It is a mechanism for the transmission of carbon and energy,\n"
                + "from the simplest to the most complex forms of life, \n"
                + "also exerting pressure on the species known as natural selection,\n"
                + "which is nothing more than the competition to survive and reproduce,\n"
                + "and is one of the most efficient engines for evolution.\n\n"
                + "\nPlease be patient while populating the World Grid..\n\n\n"
                + "===========================PLAY===========================\n\n\n";

        for (int counter = 0; counter < intro.length(); counter++) {
            System.out.print(intro.charAt(counter));
            Thread.sleep(10);
        }

    }

    private boolean checkPopulation() {
        boolean ants = false, bugs = false;
        loop:
        for (Organism[] org : orgs) {

            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    ants = true;
                }
                if (org1 instanceof DoogleBugs) {
                    bugs = true;
                }
                if (ants && bugs) {
                    break loop;
                }
            }

        }
        return ants && bugs;
    }

    private void moveOrganisms() {
        for (Organism[] org : orgs) {
            for (Organism org1 : org) {
                if (org1 instanceof Ants) {
                    org1.doMove(orgs);
                    ((Ants) org1).breed(orgs);
                    displayGrid();
                }
                if (org1 instanceof DoogleBugs) {
                    org1.doMove(orgs);
                    ((DoogleBugs) org1).breed(orgs);
                    displayGrid();

                }
                if ((org1 instanceof Ants) && (org1 instanceof DoogleBugs)) {
                    System.out.printf("==================================\n"
                            + "NO MOVE MADE\n"
                            + "==================================\n");
                    displayGrid();
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
        System.out.println("");
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
            System.out.println("\n\n");
        }
    }

}
