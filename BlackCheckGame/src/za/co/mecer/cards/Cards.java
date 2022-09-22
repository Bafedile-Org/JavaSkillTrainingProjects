package za.co.mecer.cards;

import za.co.mecer.cards.suits.Suits;
import za.co.mecer.exceptions.CardException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Cards {

    private int cardNumber;
    private Suits suit;

    public Cards() throws CardException {
        this(Suits.SPADE, 1);
    }

    public Cards(Suits suit, int cardNumber) {
        this.suit = suit;
        this.cardNumber = cardNumber;

    }

    public Suits getCardSuit() {
        return suit;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void getRank(Cards[] playerCards, int cardNum) {
        switch (playerCards[cardNum].getCardNumber()) {
            case 11:
                System.out.printf("J of %s%n", playerCards[cardNum].getCardSuit());
                break;
            case 12:
                System.out.printf("Q of %s%n", playerCards[cardNum].getCardSuit());
                break;
            case 13:
                System.out.printf("K of %s%n", playerCards[cardNum].getCardSuit());
                break;
            default:
                System.out.printf("%d of %s%n", playerCards[cardNum].getCardNumber(), playerCards[cardNum].getCardSuit());
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Suit: %s%nValue: %d%n", suit, cardNumber);
    }

}
