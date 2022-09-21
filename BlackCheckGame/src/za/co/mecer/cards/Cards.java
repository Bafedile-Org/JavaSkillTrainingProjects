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

    private void checkCardNumber(int cardNumber) throws CardException {
        if (cardNumber < 1 || cardNumber > 13) {
            throw new CardException("Invalid Card!!");
        }
    }

    @Override
    public String toString() {
        return String.format("Suit: %s%nValue: %d%n", suit, cardNumber);
    }

}
