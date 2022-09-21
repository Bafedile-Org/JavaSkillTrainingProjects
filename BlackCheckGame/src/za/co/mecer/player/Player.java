package za.co.mecer.player;

import za.co.mecer.cards.Cards;
import za.co.mecer.interfaces.CardsInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Player implements CardsInterface {

    private String name;
    private int cardSum;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void viewCards(Cards[] playerCards) {

    }

    @Override
    public int getSumOfCards(Cards[] playerCards) {
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

    @Override
    public void stickToCards() {
    }

}
