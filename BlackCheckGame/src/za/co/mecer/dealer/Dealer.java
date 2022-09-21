package za.co.mecer.dealer;

import java.util.Collections;
import java.util.Stack;
import za.co.mecer.cards.Cards;
import za.co.mecer.exceptions.CardException;
import za.co.mecer.interfaces.CardsInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Dealer implements CardsInterface {

    private String name;

    public Dealer(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void flipCards(Stack<Cards> cards, Cards[] dealerCards) throws CardException {
        while (dealerCards[dealerCards.length - 1] == null) {
            if (!(getSumOfCards(dealerCards) >= 21)) {
                Cards card = cards.pop();
                addCards(dealerCards, card);
            } else {
                break;
            }

        }
    }

    public void shuffleCards(Stack<Cards> stackCards) {
        Collections.shuffle(stackCards);
    }

    public Cards giveCard(Stack<Cards> stackCards) {
        shuffleCards(stackCards);
        return stackCards.pop();
    }
}