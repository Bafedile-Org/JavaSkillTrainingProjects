package za.co.mecer.dealer;

import java.util.Stack;
import za.co.mecer.cards.Cards;
import za.co.mecer.interfaces.CardsInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Dealer implements CardsInterface {

    private String name;
    private final int dealerCards[] = new int[5];

    public Dealer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void flipCards(Stack<Cards> cards) {
        Cards card = cards.pop();

        System.out.printf("%d of %s %n", card.getCardNumber(), card.getCardSuit());
    }

    @Override
    public void viewCards(Cards[] dealerCards) {
    }

    @Override
    public void stickToCards() {
    }
}
