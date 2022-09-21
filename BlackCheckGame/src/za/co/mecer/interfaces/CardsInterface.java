package za.co.mecer.interfaces;

import za.co.mecer.cards.Cards;
import za.co.mecer.exceptions.CardException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface CardsInterface {

    default void viewCards(Cards[] playerCards, String str) {
        System.out.printf("%s Cards%n=================================%n", str);
        for (int cardNum = 0; cardNum < playerCards.length; cardNum++) {
            if (playerCards[cardNum] == null) {
                break;
            }
            playerCards[cardNum].getRank(playerCards, cardNum);

        }
        System.out.printf("%n=================================%n");
    }

    default int getSumOfCards(Cards[] playerCards) {
        int total = 0;
        for (int cardNum = 0; cardNum < playerCards.length; cardNum++) {
            if (playerCards[cardNum] == null) {
                break;
            }
            if (playerCards[cardNum].getCardNumber() > 10) {
                total += 10;
                continue;
            }
            total += playerCards[cardNum].getCardNumber();
        }
        return total;
    }

    default void addCards(Cards[] playerCards, Cards card) throws CardException {
        if (playerCards[playerCards.length - 1] == null) {
            for (int cardNum = 0; cardNum < playerCards.length; cardNum++) {
                if (playerCards[cardNum] == null) {
                    playerCards[cardNum] = card;
                    break;
                }
            }

        } else {
            throw new CardException("Number of player cards can not be more than 5!!");
        }
    }

}
