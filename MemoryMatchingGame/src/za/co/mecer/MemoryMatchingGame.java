package za.co.mecer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import za.co.mecer.Cards.Cards;
import za.co.mecer.exceptions.CoordinatesException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MemoryMatchingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MemoryMatchingGame().run();

    }

    private void run() {
        Cards[][] cards = new Cards[4][4];
        int[][] randomNumbers = new int[4][4];
        String pointOne, pointTwo;
        boolean isValid = false;
        initializeCards(randomNumbers, cards);

        do {
            try {
                displayCardsNumbers(cards);
                pointOne = getCoordinates("First");
                pointTwo = getCoordinates("Second");
                getTheCards(cards, pointOne, pointTwo);
                displayCards(cards);
            } catch (ArrayIndexOutOfBoundsException | CoordinatesException | NumberFormatException ex) {
                System.out.printf("%nERROR: %s%n%n", ex.getMessage());
            }

        } while (!isValid);
    }

    private String getCoordinates(String msg) throws CoordinatesException {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the %s coordinates in the following (x,y): ", msg);
        String coordinates = input.next();
        if (!coordinates.contains(",")) {
            throw new CoordinatesException("Coordinates have to be in (x,y)");
        }
        return coordinates;
    }

    private void getTheCards(Cards[][] cards, String pointsOne, String pointsTwo) throws CoordinatesException {
        String pointsArr[] = pointsOne.split(",");
        String pointsArr2[] = pointsTwo.split(",");
        Cards card1 = cards[Integer.parseInt(pointsArr[0]) - 1][Integer.parseInt(pointsArr[1]) - 1];
        Cards card2 = cards[Integer.parseInt(pointsArr2[0]) - 1][Integer.parseInt(pointsArr2[1]) - 1];
        if (pointsOne.equals(pointsTwo)) {
            throw new CoordinatesException("You have chosen the same coordinates");
        }
        if (card1.getValue() == card2.getValue()) {
            card1.setFace("UP");
            card2.setFace("UP");

            System.out.println("Correct");
        } else {
            System.out.println("Wrong!!!");
            card1.setFace("UP");
            card2.setFace("UP");
            displayCards(cards);

            card1.setFace("Down");
            card2.setFace("Down");
        }
    }

    private void initializeCards(int[][] randomNumbers, Cards[][] cards) {
        addRandomNumbers(randomNumbers);
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                cards[i][j] = new Cards("Down", randomNumbers[i][j]);
            }
        }
    }

    private void addNumbers(ArrayList<Integer> randomNumbers) {
        for (int i = 1; i <= 8; i++) {
            randomNumbers.add(i);
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);
    }

    private void addRandomNumbers(int[][] randomNumbers) {
        ArrayList<Integer> numbers = new ArrayList<>();
        addNumbers(numbers);
        int counter = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = 0; j < randomNumbers[i].length; j++) {
                randomNumbers[i][j] = numbers.get(counter);
                counter++;
            }

        }
    }

    private void displayCards(Cards[][] cards) {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j].getFace().equalsIgnoreCase("down")) {
                    System.out.printf("%s\t", "*");
                } else {
                    System.out.printf("%s\t", cards[i][j].getValue());
                }
            }
            System.out.println();
        }
    }

    private void displayCardsNumbers(Cards[][] cards) {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                System.out.print(cards[i][j].getValue() + "  ");
            }
            System.out.println("");
        }
    }

}
