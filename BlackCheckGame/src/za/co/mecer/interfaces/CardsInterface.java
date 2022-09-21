package za.co.mecer.interfaces;

import za.co.mecer.cards.Cards;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface CardsInterface {

    void viewCards(Cards[] playerCards);

    default int getSumOfCards(Cards[] playerCards) {
        int total = 0;
        for (int cardNum = 0; cardNum < playerCards.length; cardNum++) {
            if (playerCards[cardNum].getCardNumber() > 10) {
                total += 10;
                continue;
            }
            total += playerCards[cardNum].getCardNumber();
        }
        return total;
    }

    void stickToCards();

}
